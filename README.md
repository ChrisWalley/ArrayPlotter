# ArrayPlotter
Simple java application to draw a 2-D grid array.
The ArrayPlotter.java contains all the code to draw the array. Look in main java for how to use it.

All you have to do is copy the ArrayPlotter.java class into your current project, and then update it with a new 2D int [][] every time something changes.

Example:

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
