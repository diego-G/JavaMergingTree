### Merging tree excersice

It seeks to merge two trees and generate a full layout of the resultant tree. Here, there are two sample files with info about two trees. Each line contains data of the paths formed as "path : weight". Each path contains other paths separated by slashes or dots.

File1

    A/B/C : 1
    A/B : 1
    A1/B1/C : 1

File2

    A.C : 1
    A.B : 1
    A.B.D : 3
    A.B.C : 1
    A2/B/C : 4

Expected result :

    A : 8
    A/B : 7
    A/B/C : 2
    A/B/D : 3
    A/C : 1
    A1 : 1
    A1/B1 : 1
    A1/B1/C : 1
    A2 : 4
    A2/B : 4 
    A2/B/C : 4

### Merging tree solution
A Java test case is implemented. It loads two files, merges the two loaded trees and generates a full tree description.
