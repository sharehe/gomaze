package cn.sharehe.goMaze.maze;
import cn.sharehe.goMaze.utils.AlgoVisHelper;

import javax.swing.*;
import java.awt.*;

/**
 * 绘制窗口
 * @Author: wugui
 * @Date 2018-6-9 12:03
 */
public class AlgoJFrame extends JFrame{
    private MazeData mazeDataHandle;
    private int width;
    private int height;
    private String topText;
    public AlgoJFrame(int width, int height, String title, MazeData mazeDataHandle){
        super(title);
        this.width = width;
        this.height = height+30;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AlgoJpanl algoJFrame = new AlgoJpanl();
        this.setContentPane(algoJFrame);
        this.pack();
        this.mazeDataHandle = mazeDataHandle;
        this.addKeyListener(new MyKeyListener(this, this.mazeDataHandle));
        topText = "迷宫生成中请等待。。。";
    }

    public void setTopText(String text){
        this.topText = text;
    }

    /**
     * 更新画布
     * @param mazeDataHandle
     */
    public void rePaint(MazeData mazeDataHandle) {
        this.mazeDataHandle = mazeDataHandle;
        super.repaint();
    }

    private class AlgoJpanl extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            int h = height / mazeDataHandle.getrSize();
            int w = width / mazeDataHandle.getcSize();
            AlgoVisHelper.drawText(g2d,topText,width/2,15);
            for (int i = 0; i < mazeDataHandle.getrSize(); i++) {
                for (int j = 0; j < mazeDataHandle.getcSize(); j++){
                    if (mazeDataHandle.getMazeItem(i, j) == MazeData.WALL){
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.Cyan);
                    }else{
                        AlgoVisHelper.setColor(g2d, AlgoVisHelper.White);
                    }
                    AlgoVisHelper.fillRectangle(g2d,j * h, i * w + 30, w, h);
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Yellow);
                    if(mazeDataHandle.getRoadItem(i, j)){
                        AlgoVisHelper.fillRectangle(g2d, j * h, i * w + 30, w, h);
                    }
                }
            }
        }

        /**
         * 当前画布大小设置为窗口大小
         * @return
         */
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }
    }


}
