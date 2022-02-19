class GNode:
    def __init__(self):
        self.indegree = 0
        self.outNodes = []
        
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
        dag = defaultdict(GNode)
        total_dependencies = 0
        for pair in prerequisites:
            course, prereq = pair[0], pair[1]
            dag[course].indegree += 1
            dag[prereq].outNodes.append(course)
            total_dependencies += 1
        
        
            
        queue = deque()
        for course_num, details in dag.items():
            if details.indegree == 0:
                queue.append(course_num)
        
        cleared_courses = 0
        while queue:
            course = queue.pop()
            outs = dag[course].outNodes
            for node in outs:
                dag[node].indegree -= 1
                if dag[node].indegree == 0:
                    queue.append(node)
                cleared_courses += 1
        
        if total_dependencies == cleared_courses:
            return True
        
        return False
            
            