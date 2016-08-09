//solution #1:Brute Force
public class Solution{
	public int[] twoSum(int[] nums,int target){
		for(int i=0;i<nums.length;i++){
			for(int j=i;j<nums.length;j++){
				if(nums[i]==target-nums[j])
					return new int[]{i,j};
			}
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
}

//solution #2:Two pass Hash Table
public class Solution2{
	public int[] twoSum(int[] nums,int target){
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;iu++){
			map.put(nums[i],i);
		}

		for(int i=0;i<nums.length;i++){
			int left=target-nums[i];
			if(map.containsKey(left) && map.get(left)!=i)
				return new int[]{i,map.get(left)};
		}
		throw new IllegalArgumentException("No two sum solution.");
	}
}

//solution #3:One pass Hash Table
public class Solution3{
	public int[] twoSum(int[] nums,int target){
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++){
			int left=target-nums[i];
			if(map.containsKey(left)){
				return new int[]{i,map.get(left)};
			}
			map.put(nums[i],i);
		}
	}
}
