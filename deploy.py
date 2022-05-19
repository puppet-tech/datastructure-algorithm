import imp
from operator import le
import sys
import subprocess
# from loguru import logger


def check_call_plus(command: str, cwd='.dist') -> int:
    """再度封装 subprocess.check_call，使其默认 shell 入参为 True，cwd 缺省值为 .dist

    Args:
        commad (str): 要执行的 shell 或 cmd 命令
        cwd (str, optional): command 命令的执行目录（路径），如果要在当前目录下执行，则传入 None. Defaults to '.dist'.

    Returns:
        int: 同 subprocess.check_call 的返回值
    """
    return subprocess.check_call(command, shell=True, cwd=cwd)


def init_and_push():
    # 初始化仓库，将编译后的静态文件跟踪起来
    check_call_plus("git init")
    check_call_plus("git add -A")
    check_call_plus("git commit -m 'deploy'")

    # 如果发布到 https://<USERNAME>.github.io
    # git push -f git@github.com:<USERNAME>/<USERNAME>.github.io.git master

    # 如果发布到 https://<USERNAME>.github.io/<REPO>
    # git push -f https://github.com/<USERNAME>/<REPO>.git master:gh-pages

    # 该命令推上到远程后，将在远程上新建 gh-pages 分支；实际上代码是被推上到了 gh-pages 分支上
    # git push -f git@github.com:puppetdevz/blog.git main:gh-pages

    # 将编译后的项目，强推到远程的 main 分支上
    check_call_plus("git push -f https://github.com/puppetdevz/blog.git main")


def push_src():
    print('开始-将博客源代码提交到仓库中')
    check_call_plus("git add .", None)
    try:
        check_call_plus("git commit -m '_'", None)
    except subprocess.CalledProcessError as e:
        print('commit命令执行失败')
        # print('retcode is ' + str(err.returncode))
        # print('failed cmd is ' + str(err.cmd))
    try:
        check_call_plus("git push", None)
    except subprocess.CalledProcessError as e:
        print('push命令执行失败')
        # print('retcode is ' + str(err.returncode))
        # print('failed cmd is ' + str(err.cmd))
    print('结束-将博客源代码提交到仓库中')


def pull_src():
    print('开始-拉取源代码')
    try:
        check_call_plus("git pull", None)
    except subprocess.CalledProcessError as e:
        print('pull命令执行失败')
        # print('retcode is ' + str(err.returncode))
        # print('failed cmd is ' + str(err.cmd))
    print('结束-拉取源代码')


def push_static():
    # 下面开始将编译后的文档发布到 GitHub Pages 上
    # 构建项目，生成静态文件
    check_call_plus("yarn build", None)

    # 域名绑定
    check_call_plus("echo puppetdev.top > CNAME")
    # 调用函数，将项目编译后生成静态文件初始化为一个仓库，然后推送到远程
    init_and_push()


if __name__ == '__main__':
    print('sys.argv is ' + str(sys.argv))
    print('the path of python is ' + str(sys.path))
    if len(sys.argv) == 1:
        push_src()
        push_static()
    elif len(sys.argv) == 2 and sys.argv[1] == '--push-src':
        push_src()
    elif len(sys.argv) == 2 and sys.argv[1] == '--pull-src':
        pull_src()
    else:
        raise Exception('不存在该命令')
