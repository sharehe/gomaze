package cn.sharehe.goMaze.maze;

/**
 * 创建迷宫数据处理
 * @Author: wugui
 * @Date 2018-6-10 10:27
 */
public class MazeData {
    public static final char WALL = '#';
    public static final char ROAD = ' ';
    private boolean overs[][];      // 记录遍历过的点 true为遍历过
    private boolean roads[][];      // 记录走过的路径 true为走过
    private int rSize;
    private int cSize;
    private char dataMaze[][];      // 保存迷宫 空格表示为路 #表示围墙
    private boolean isCreateSuccess;    // 迷宫是否创建成功的标记值
    public MazeData(int rSize, int cSize) {
        this.rSize = rSize;
        this.cSize = cSize;
        dataMaze = new char[rSize][cSize];
        overs = new boolean[rSize][cSize];
        roads = new boolean[rSize][cSize];
        for (int i = 0; i < rSize; i++) {
            for (int j = 0; j < cSize; j++) {
                if (i % 2 == 1 && j % 2 ==1)
                    dataMaze[i][j] = ' ';
                else
                    dataMaze[i][j] = '#';
            }
        }
        // 设置入口
        dataMaze[1][0] = ' ';
        // 设置出口
        dataMaze[rSize - 2][cSize - 1] = ' ';
    }

    /**
     * 检测数组下标是否越界
     * @param x
     * @param y
     * @return 越界返回true
     */
    public boolean isOut(int x, int y){
        if (x < 0 || y < 0 || x >=this.rSize || y >= this.cSize)
            return true;
        return false;
    }

    /**
     * 获得指定位置的值
     * @param x
     * @param y
     * @return
     */
    public char getMazeItem(int x, int y){
        if (isOut(x, y))
            throw new IllegalArgumentException("数组下标越界");
        return dataMaze[x][y];
    }
    public boolean getRoadItem(int x, int y){
        if (isOut(x, y))
            throw new IllegalArgumentException("数组下标越界");
        return roads[x][y];
    }
    public boolean getOverItem(int x, int y){
        if (isOut(x, y))
            throw new IllegalArgumentException("数组下标越界");
        return overs[x][y];
    }

    /**
     * 设置对应值
     * @param x
     * @param y
     */
    public void setDataItem(int x, int y){
        if (isOut(x, y))
            throw new IllegalArgumentException("数组下标越界");
        dataMaze[x][y] = ' ';
    }

    /**
     * 初始化 标记是否遍历的数组 用于生成与走迷宫之间
     */
    public void setInitOver(){
        overs = new boolean[rSize][cSize];
    }
    public void setRoadItem(int x, int y){
        roads[x][y] = true;
    }
    public void setRoadItemF(int x, int y){
        roads[x][y] = false;
    }
    public void setOverItem(int x, int y){
        if (isOut(x, y))
            throw new IllegalArgumentException("数组下标越界");
        overs[x][y] = true;
    }
    public int getrSize() {
        return rSize;
    }

    public int getcSize() {
        return cSize;
    }
    public void setCreateSuccess(){
        this.isCreateSuccess = true;
    }
    public boolean isCreateSuccess(){
        return this.isCreateSuccess;
    }
}
