# original post 
# https://leetcode.com/problems/trapping-rain-water/discuss/1374608/C%2B%2BJavaPython-MaxLeft-MaxRight-so-far-with-Picture-O(1)-space-Clean-and-Concise

class Solutions:
    def trap(self, height) -> int:
        n = len(height)

        # max left/right = heights from left/right of current index
        # think parallel dimensions (arrays in this case)
        max_left, max_right = [0] * n, [0] * n

        # finding current index's left maxes
        # skipping first because no left wall
        for i in range(1, n):
            max_left[i] = max(height[i-1], max_left[i-1])
        
        #finding current index's right maxes
        # skipping first because no right wall
        for i in range(n-2, -1, -1):
            max_right[i] = max(height[i+1], max_right[i+1])

        
        # iterating heights - looking for left/right walls
        # adding/calculating capacity
        res = 0
        for i in range(n):
            water_level = min(max_left[i], max_right[i])
            if water_level >= height[i]:
                res += water_level - height[i]
        return res
