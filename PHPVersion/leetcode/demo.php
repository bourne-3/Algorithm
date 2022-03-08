<?php
## https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
# 数组中重复的数字
/***
 * 1 将该值作为下标，寻找对应的替换
 * 2 这个for不需要每次都加上i
 */
echo 'ok';
$sampleInput = [2, 3, 1, 0, 2, 5, 3];



function findRepeatNumber($nums) {
    for ($i = 0; $i < count($nums);) {
        if ($i == $nums[$i]) {
            $i++;
            continue;
        }

        if ($nums[$i] == $nums[$nums[$i]]) return $nums[$i];
        
        $originName = $nums[$i];
        $nums[$i] = $nums[$originName];
        $nums[$originName] = $originName;
    }
    return -1;
}