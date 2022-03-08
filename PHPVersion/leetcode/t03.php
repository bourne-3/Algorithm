<?php
## https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
# 数组中重复的数字
/***
 * 1 将该值作为下标，寻找对应的替换
 * 2 这个for不需要每次都加上i
 * 3 修改变量的名字，做到见名知意
 */
echo 'ok';
$sampleInput = [2, 3, 1, 0, 2, 5, 3];



function findRepeatNumber($nums) {
    for ($originIdx = 0; $originIdx < count($nums);) {
        if ($originIdx == $nums[$originIdx]) {
            $originIdx++;
            continue;
        }

        if ($nums[$originIdx] == $nums[$nums[$originIdx]]) return $nums[$originIdx];
        
        $targetIdx = $nums[$originIdx];
        $nums[$originIdx] = $nums[$targetIdx];
        $nums[$targetIdx] = $targetIdx;
    }
    return -1;
}