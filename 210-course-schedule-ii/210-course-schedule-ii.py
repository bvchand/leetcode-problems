class GNode:
    def __init__(self):
        self.indegree = 0
        self.outNodes = []
        
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        dag = defaultdict(GNode)
        
        dag = {key:GNode() for key in range(numCourses)}
        print(dag)
        
        for relations in prerequisites:
            course, prereq = relations
            dag[course].indegree += 1
            dag[prereq].outNodes.append(course)
        
        queue = deque()
        for course, details in dag.items():
            if details.indegree == 0:
                queue.append(course)
        
        result = []
        while queue:
            course = queue.pop()
            result.append(course)
            for c in dag[course].outNodes:
                dag[c].indegree -= 1
                if dag[c].indegree == 0:
                    queue.append(c)

        return result if numCourses == len(result) else []
            