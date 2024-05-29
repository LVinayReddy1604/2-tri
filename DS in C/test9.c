#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
int adj[20][20], n, m, q[20], visited[20], f = -1, r = -1;

struct edge
{
    int s, d;
};

struct edge e[20];

void createadjmatrix(struct edge e[])
{
    int i, j, x, y;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            adj[i][j] = 0;
        }
    }

    for (i = 0; i < m; i++)
    {
        x = e[i].s;
        y = e[i].d;
        adj[x][y] = 1;
        adj[y][x] = 1; 
    }
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
            printf("%d ", adj[i][j]);
        printf("\n");
    }
}

void bfs(int v)
{
    int i;
    for (i = 0; i < n; i++) 
    {
        if (adj[v][i] != 0 && visited[i] == 0)
        {
            r = r + 1;
            q[r] = i;           
            visited[i] = 1;     
            printf("%d  ", i);
        }
    }
    f = f + 1; 
    if (f <= r) 
        bfs(q[f]); 
}

void dfs(int v)
{
    int i;
    for (i = 0; i < n; i++) 
    {
        if (adj[v][i] != 0 && visited[i] == 0)
        {
            visited[i] = 1;
            printf("%d  ", i);
            dfs(i);
        }
    }
}

int main()
{
    int i, j, v;
    char ch = 'y';
    m = 0;
    i = 0;
    printf("Enter no of vertices: ");
    scanf("%d", &n);

    while (ch == 'y')
    {
        printf("Enter source of edge: ");
        scanf("%d", &e[i].s);
        printf("Enter destination of edge: ");
        scanf("%d", &e[i].d);
        printf("Do you want to add more edges? (y/n): ");
        fflush(stdin);
        scanf(" %c", &ch);
        m = m + 1;
        i++;
    }

    createadjmatrix(e);

    for (i = 0; i < n; i++) 
    {
        visited[i] = 0;
    }

    printf("\nEnter the starting vertex for BFS: ");
    scanf("%d", &v);
    f = r = 0;
    q[r] = v;
    printf("\nBFS traversal is:\n");
    visited[v] = 1; 
    printf("%d   ", v);
    bfs(v);
    if (r != n - 1)
        printf("\nBFS is not possible");

    for (i = 0; i < n; i++)
    {
        visited[i] = 0;
    }

    printf("\nEnter the starting vertex for DFS: ");
    scanf("%d", &v);
    printf("\nDFS traversal is:\n");
    visited[v] = 1;
    printf("%d   ", v);
    dfs(v);
    getch();
    return 0;
}
