package cn.sharehe.goMaze.maze;

import cn.sharehe.goMaze.utils.AlgoVisHelper;

/**
 * 走迷宫线程
 * @Author: wugui
 * @Date 2018-6-10 14:39
 */
public class GoMazeThread implements Runnable {
    private AlgoJFrame algoJFrame;
    private MazeData createMazeData;
    // 每次迭代的4个方向
    private int d[][] = {{0,1},{1,0},{0,-1},{-1,0}};

    public GoMazeThread(AlgoJFrame algoJFrame, MazeData createMazeData) {
        this.algoJFrame = algoJFrame;
        this.createMazeData = createMazeData;
    }

    @Override
    public void run() {
        goMaze(1,0);
        algoJFrame.setTopText("迷宫已走完");
    }

    /**
     * 递归深度搜索
     * @param i
     * @param j
     * @return
     */
    boolean goMaze(int i, int j){
        createMazeData.setOverItem(i,j);
        createMazeData.setRoadItem(i, j);
        this.algoJFrame.rePaint(createMazeData);
        AlgoVisHelper.pause(30);
        if (i == createMazeData.getrSize() - 2 && j == createMazeData.getcSize()-1)
            return true;
        int newX,newY;
        for (int k = 0; k < d.length; k++) {
            newX = i + d[k][0];
            newY = j + d[k][1];
            if (! createMazeData.getOverItem(newX,newY)
                    && createMazeData.getMazeItem(newX,newY) == MazeData.ROAD
                    && ! createMazeData.isOut(newX,newY))
                if (goMaze(newX,newY))
                    return true;
        }
        createMazeData.setRoadItemF(i,j);
        return false;
    }
}
