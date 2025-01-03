#include <stdio.h>
#include <stdbool.h>
#define MAX_VERTICES 100
#define MAX 9999

typedef struct {
    int u, v, weight;
} Edge;

// Function declarations
void primMST(int graph[MAX_VERTICES][MAX_VERTICES], int V);
void kruskalMST(int graph[MAX_VERTICES][MAX_VERTICES], int V);
int find(int parent[], int i);
void unionSets(int parent[], int x, int y);

int main() {
    int graph[MAX_VERTICES][MAX_VERTICES];
    int V, E, i, j;

    printf("Enter the number of vertices and edges: ");
    scanf("%d %d", &V, &E);

    // Initialize the matrix with zeros
    for (i = 0; i < V; ++i)
        for (j = 0; j < V; ++j)
            graph[i][j] = 0;

    printf("Enter the edges (src dest weight) for each edge:\n");
    for (i = 0; i < E; ++i) {
        int src, dest, weight;
        scanf("%d %d %d", &src, &dest, &weight);

        // For undirected graph, add the weight to both src-dest and dest-src
        graph[src - 1][dest - 1] = weight;
        graph[dest - 1][src - 1] = weight;
    }

    // Display the graph matrix
    printf("\nGraph Matrix:\n");
    for (i = 0; i < V; ++i) {
        for (j = 0; j < V; ++j)
            printf("%d\t", graph[i][j]);
        printf("\n");
    }

    // Perform Prim's algorithm and display the MST details
    primMST(graph, V);

    // Perform Kruskal's algorithm and display the MST details
    kruskalMST(graph, V);

    return 0;
}

// Prim's Algorithm
void primMST(int graph[MAX_VERTICES][MAX_VERTICES], int V) {
    int parent[V];
    int key[V];
    bool mstSet[V];
    int i, count, v;

    // Initialize key values and mstSet
    for (i = 0; i < V; ++i) {
        key[i] = MAX;
        mstSet[i] = false;
    }

    key[0] = 0; // Start from the first vertex

    for (count = 0; count < V - 1; ++count) {
        int u, minKey = MAX;

        // Find the vertex with the minimum key value
        for (v = 0; v < V; ++v) {
            if (!mstSet[v] && key[v] < minKey) {
                minKey = key[v];
                u = v;
            }
        }

        mstSet[u] = true;

        // Update key values and parent for adjacent vertices
        for (v = 0; v < V; ++v) {
            if (graph[u][v] && !mstSet[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }

    // Display the details of MST obtained from Prim's Algorithm
    printf("\nPrim's Algorithm MST:\n");
    for (i = 1; i < V; ++i)
        printf("%d -- %d\tWeight: %d\n", parent[i], i, graph[i][parent[i]]);
}

// Kruskal's Algorithm
void kruskalMST(int graph[MAX_VERTICES][MAX_VERTICES], int V) {
    Edge edges[V * V];
    int e = 0;
    int i, j, k, l, v;

    // Extract edges from the adjacency matrix
    for (i = 0; i < V; ++i)
        for (j = 0; j < V; ++j)
            if (graph[i][j] != 0) {
                edges[e].u = i;
                edges[e].v = j;
                edges[e].weight = graph[i][j];
                ++e;
            }

    // Sort edges in non-decreasing order of weight
    for (j = 0; j < e - 1; ++j)
        for (k = 0; k < e - j - 1; ++k)
            if (edges[k].weight > edges[k + 1].weight) {
                // Swap the edges
                Edge temp = edges[k];
                edges[k] = edges[k + 1];
                edges[k + 1] = temp;
            }

    // Create a parent array for union-find
    int parent[V];
    for (v = 0; v < V; ++v)
        parent[v] = v;

    i = 0;

    printf("Kruskal's Algorithm\n");
    while (i < e) {
        int u = edges[i].u;
        int v = edges[i].v;
        int weight = edges[i].weight;

        int x = find(parent, u);
        int y = find(parent, v);

        if (x != y) {
            printf("%d -- %d\tWeight: %d\n", u, v, weight);
            unionSets(parent, x, y);
        }

        ++i;
    }
}

// Helper functions for union-find
int find(int parent[], int i) {
    while (parent[i] != i)
        i = parent[i];
    return i;
}

void unionSets(int parent[], int x, int y) {
    int xroot = find(parent, x);
    int yroot = find(parent, y);
    parent[xroot] = yroot;
}
