package cn.sharehe.goMaze.maze;

/**
 * 程序入口
 * @Author: wugui
 * @Date 2018-6-10 10:50
 */
public class Controller {
    public static void main(String[] args) {
        MazeData createMazeData = new MazeData(101,101);
        AlgoJFrame algoJFrame = new AlgoJFrame(101*6,101*6,"糖豆豆同学",createMazeData);
        algoJFrame.rePaint(createMazeData);
        algoJFrame.setVisible(true);
        new Thread(new CreateMazeThread(algoJFrame,createMazeData)).start();
    }
}
