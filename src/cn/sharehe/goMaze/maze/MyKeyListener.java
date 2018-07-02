package cn.sharehe.goMaze.maze;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘监听
 * @Author: wugui
 * @Date 2018-6-10 14:25
 */
public class MyKeyListener implements KeyListener {
    private AlgoJFrame algoJFrame;
    private MazeData mazeData;
    private boolean one;
    public MyKeyListener(AlgoJFrame algoJFrame, MazeData mazeData) {
        this.algoJFrame = algoJFrame;
        this.mazeData = mazeData;
        one = true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 在迷宫创建成功后才执行
        if(mazeData != null && mazeData.isCreateSuccess() && one){
            one = false;        //只能执行一次
            new Thread(new GoMazeThread(algoJFrame,mazeData)).start();
            algoJFrame.setTopText("正在走迷宫请等待。。。");
        }else{
            System.out.println("迷宫生成中请等待。。。");
        }
    }
}
