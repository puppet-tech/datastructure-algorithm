package org.example.stack;

/**
 * 基于数组的顺序栈
 * @author puppet
 * @since 2022/1/31 4:19 下午
 */
public class ArrayStack {
    /**数组容器*/
    private String[] items;

    /**栈中的元素元素*/
    private int count;

    /**栈的大小*/
    private int size;

    public ArrayStack(int size) {
        this.items = new String[size];
        this.count = 0;
        this.size = size;
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public boolean push(String item) {
        // 如果栈中元素数量与栈的大小一致，说明已经栈已满，入栈失败
        if (count == size) {
            return false;
        }
        // 否则入栈成功
        items[this.count] = item;
        ++this.count;
        return true;
    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        // 如果栈为空，则返回 null
        if (count == 0) {
            return null;
        }
        --this.count;
        return this.items[count];
    }
}
