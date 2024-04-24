<H1>slidingPuzzles</H1> 
Project files for solving sliding puzzles with the shortest path using a* algorithm. ( 2nd year algo cw)

<h2>PROJECT PROBLEM</h2>
In this project, we use path finding to solve a type of puzzle that occurs in many video games. The basic version that we will be dealing with is this: <BR> 
.....0...S <BR> 
....0..... <BR> 
0.....0..0 <BR> 
...0....0. <BR> 
.F......0. <BR> 
.0........ <BR> 
.......0.. <BR> 
.0.0..0..0 <BR> 
0......... <BR> 
.00.....0. <BR> 

The player starts at the location labelled “S” and wants to reach the finish, labelled “F”. Each turn they choose one of the four cardinal directions to move. However, except for S and F the floor is covered in frictionless ice, so they will keep sliding in the chosen direction until they hit the wall surrounding the area, or one of the rocks (labelled “0”). For example, starting in the map given above:<BR> 
.....0...@ <BR> 
....0..... <BR> 
0.....0..0 <BR> 
...0....0. <BR> 
.F......0. <BR> 
.0........ <BR> 
.......0.. <BR> 
.0.0..0..0 <BR> 
0......... <BR> 
.00.....0. <BR> 
the player (“@”) moving left would end up here:<BR> 
.....0@..S <BR> 
....0..... <BR> 
0.....0..0 <BR> 
...0....0. <BR> 
.F......0. <BR> 
.0........ <BR> 
.......0.. <BR> 
.0.0..0..0 <BR> 
0......... <BR> 
.00.....0. <BR> 
So we are dealing with the problem of finding a path from S to F, but the reachability relation between points is not the usual one <BR> 

<h2>PROJECT SOLUTION</h2>

1. Start at (10,1)<BR> 
2. Move left to (7,1)<BR> 
3. Move down to (7,2)<BR> 
4. Move left to (6,2)<BR> 
5. Move down to (6,10)<BR> 
6. Move right to (8,10)<BR> 
7. Move up to (8,8)<BR> 
8. Move right to (9,8)<BR> 
9. Move up to (9,6)<BR> 
10. Move left to (3,6)<BR> 
11. Move up to (3,1)<BR> 
12. Move left to (1,1)<BR> 
13. Move down to (1,2)<BR> 
14. Move right to (4,2)<BR> 
15. Move down to (4,3)<BR> 
16. Move left to (2,3)<BR> 
17. Move down to (2,5)<BR> 
18. Done!<BR> 
Where the squares are numbered left to right, top to bottom
