class UndergroundSystem:
            

    def __init__(self):
        self.arrivals = collections.defaultdict(list)
        self.time_taken = collections.defaultdict(lambda: [0, 0])

    def checkIn(self, id: int, stationName: str, t: int) -> None:
        self.arrivals[id] = [stationName, t]
        

    def checkOut(self, id: int, end_station: str, t: int) -> None:
        start_station, start_time = self.arrivals.pop(id)
        self.time_taken[(start_station, end_station)][0] += (t - start_time)
        self.time_taken[(start_station, end_station)][1] += 1

    def getAverageTime(self, startStation: str, endStation: str) -> float:
        total_time, total_trips = self.time_taken[(startStation, endStation)]
        return total_time / total_trips


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)