import java.util.Arrays;

public class Main {
    public static void main(String... args)
    {
        //First initialise your 2-D int array
        int [] [] grid = new int [50][50];
        for(int [] row : grid)
        {
            Arrays.fill(row,0);
        }

        //Start the plotter
        ArrayPlotter plotter = new ArrayPlotter(grid.length,grid[0].length, 10);
        plotter.start();

        //Then update it with the new grid every time something changes.
        plotter.update(grid);

        //The below code changes a random block to a random color
        while(true)
        {
            int x = (int) (Math.random()*50);
            int y = (int) (Math.random()*50);
            int val = (int) (Math.random()*10);
            grid[x][y] = val;
            plotter.update(grid);
        }
    }
}
