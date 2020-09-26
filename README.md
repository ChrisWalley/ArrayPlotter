# ArrayPlotter
Simple java application to draw a 2-D grid array.
The ArrayPlotter.java contains all the code to draw the array. Look in main java for how to use it.

All you have to do is copy the ArrayPlotter.java class into your current project, and then update it with a new 2D int [][] every time something changes.

How it works is by colouring each block of the grid based on the integer value found at its xy coordinate in the array. Colours are defined in the cols array in the ArrayPlotter.java class as follows:

            Color [] cols = new Color[]
            {
                    Color.WHITE,
                    Color.MAGENTA,
                    Color.YELLOW,
                    Color.PINK,
                    Color.DARK_GRAY,
                    Color.RED,
                    Color.GREEN,
                    Color.BLUE,
                    Color.YELLOW
            };
            
For example if my array contains the value 3 at position [25][35], then on the grid the block in row 35, column 25 will be coloured Pink.

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
