package cn.sharehe.goMaze.maze;

import java.util.LinkedList;
/**
 * 随机队列
 * @Author: wugui
 * @Date 2018-6-10 13:30
 */
public class RandeQueue<T> {
    private LinkedList<T> queue;

    public RandeQueue() {
        this.queue = new LinkedList<>();
    }

    /**
     * 随机插入到队尾或者队头
     * @param t
     */
    public void add(T t){
        if(Math.random() > 0.5)
            this.queue.addLast(t);
        else
            this.queue.addFirst(t);
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        if(this.queue.size() > 0)
            return false;
        return true;
    }

    /**
     * 随机在队首或者队尾获得元素
     * @return
     */
    public T remove(){
        if(this.queue.size() == 0)
            throw new IllegalArgumentException("没有啦");
        T t;
        if (Math.random() > 0.5)
            t = this.queue.removeFirst();
        else
            t = this.queue.removeLast();
        return t;
    }
}
