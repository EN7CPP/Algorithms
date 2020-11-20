#include <iostream>
#include <climits>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int* dijkstra(int n, int start, vector<vector<int>>& roads) {
    auto compare=[](pair<int,int>& p1,pair<int,int>& p2){return std::get<1>(p1) >= std::get<1>(p2);};
    vector<vector<pair<int,int>>> adj(roads.size());
    priority_queue<pair<int,int>,vector<pair<int,int>>,decltype(compare)> q(compare);
    int* distances=new int[n];
    fill_n(distances,n,INT_MAX);
    distances[start-1]=0;
    bool visited[n];
    fill_n(visited,n,false);
    
    for(int i=0;i<roads.size();++i){
        adj[roads[i][0]-1].push_back(pair<int,int>(roads[i][1]-1,roads[i][2]));
        adj[roads[i][1]-1].push_back(pair<int,int>(roads[i][0]-1,roads[i][2]));
    }
    for(int i=0;i<n;++i){
        if(i!=start-1){
            q.push(pair<int,int>(i,INT_MAX));
        }
        else{
            q.push(pair<int,int>(i,0));
        }
    }
    
    /*
    //Adjecency matrix traversal
    for(auto& v:adj){
        for(auto p:v){
           std::cout<<get<0>(p)+1<<" "<<get<1>(p)<<"     "<<endl;
        }
    }
    */
    
    int p_d=0;
    while(!q.empty()){

        auto p=q.top();
        /*
        std::cout<<get<0>(p)+1<<" "<<get<1>(p)<<endl;
        for(int i:distances){
            std::cout<<i<<"  ";
        }
        std::cout<<endl;
        */
        if(visited[get<0>(p)]){q.pop();continue;}
        visited[get<0>(p)]=true;
        p_d=get<1>(p);
        for(auto c:adj[get<0>(p)]){
            if(visited[get<0>(c)])continue;
            //std::cout<<get<0>(c)<<" "<<get<1>(c);
            //cout<<endl;
            if(p_d+get<1>(c)<distances[get<0>(c)]){
                distances[get<0>(c)]=p_d+get<1>(c);
                q.push(pair<int,int>(get<0>(c),distances[get<0>(c)]));
            }
        }
        q.pop();
    }
    
    return distances;
}



int main() {
    //Note the vertices are numbered from 1 to n 
    vector<vector<int>> graph={{1,2,3},    // vertex_1,vertex_2,weight
                               {2,3,1}, 
                               {2,4,2}, 
                               {3,5,4}, 
                               {4,5,3}};
    int n=5,source=3;
    int * distances=dijkstra(5,3,graph);
    for(int i=0;i<n;++i){
        std::cout<<distances[i]<<" ";
    }
    
    delete [] distances;
    return 0;
}
