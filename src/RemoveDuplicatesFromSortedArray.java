import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums={10,10,2,2,4,5,7,7};
        int j=1;
//        int[] nums1=new int[nums.length];

 for (int i=1;i<nums.length;i++) {


         if(nums[i]!=nums[i-1])
         {
             nums[j] = nums[i];
             j++;
         }


 }

for (int i=0;i<j;i++)
{
    System.out.println(nums[i]);
}

//        int[]  nums2= Arrays.copyOf(nums1,j);
//
//        for (int value:nums2
//             ) {
//            System.out.println(value);
//
//        }


    }
}
