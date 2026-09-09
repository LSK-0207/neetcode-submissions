class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) graph.add(new ArrayList<>());
        for(int[] pre: prerequisites){
            graph.get(pre[0]).add(pre[1]);
            inDegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int finish=0;
        int[] result = new int[numCourses];
        while(!queue.isEmpty()){
            int course = queue.poll();
            result[numCourses-finish-1]=course;
            finish++;
            for(int next: graph.get(course)){
                inDegree[next]--;
                if(inDegree[next]==0) queue.offer(next);
            }
        }
        if(finish!=numCourses) return new int[0];
        return result;
    }
}
