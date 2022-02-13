class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        arr = [0]*length
        for update in updates:
            start, end, incr = update
            arr[start] += incr
            if end < length-1:
                arr[end+1] -= incr
        return list(itertools.accumulate(arr))