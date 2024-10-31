package double_week_od_prepare.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seatNum = Integer.parseInt(sc.nextLine());

        String tmp = sc.nextLine();
        int[] searOrLeave =
                Arrays.stream(tmp.substring(1, tmp.length() - 1).split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        System.out.println(getResult(seatNum, searOrLeave));
    }

    public static int getResult(int seatNum, int[] seatOrLeave) {
        // 记录已经坐人位置的序号
        ArrayList<Integer> seatIdx = new ArrayList<>();

        // 记录题解
        int lastSeatIdx = -1;

        // 遍历员工的进出顺序
        for (int info : seatOrLeave) {
            // 如果当前元素值为负数，表示出场（特殊：位置 0 的员工不会离开）
            // 例如 -4 表示坐在位置 4 的员工离开（保证有员工坐在该座位上）
            if (info < 0) {
                int leaveIdx = -info;
                seatIdx.remove(new Integer(leaveIdx));
                continue;
            }

            // 如果当前元素值为 1，表示进场
            // 如果没有空闲位置，则坐不下
            if (seatIdx.size() == seatNum) {
                // 假设当前人就是最后一个人
                lastSeatIdx = -1;
                continue;
            }

            if (seatIdx.size() == 0) {
                // 当前人员进场前，座位上没有人，则当前人员是第一个进场的，直接坐第0个位置
                seatIdx.add(0);
                lastSeatIdx = 0;
            } else if (seatIdx.size() == 1) {
                // 当前人员进场前，座位上只有一个人，那么这个人肯定坐在第0个位置，则当前进场的人坐在 seatNum - 1 位置才能离 0 位置最远
                seatIdx.add(seatNum - 1);
                lastSeatIdx = seatNum - 1;
            } else {
                // 记录具有最大社交距离的座位号
                int bestSeatIdx = -1;
                // 记录最大社交距离
                int bestSeatDis = -1;

                // 找到连续空闲座位区域（该区域左、右边界是坐了人的座位）

                int left = seatIdx.get(0); // 左边界
                for (int i = 1; i < seatIdx.size(); i++) {
                    int right = seatIdx.get(i); // 右边界

                    // 连续空闲座位区域的长度
                    int dis = right - left - 1;

                    // 如果连续空闲座位区域长度为0，则无法坐人，此时遍历下一个连续空闲座位区域
                    // 如果连续空闲座位区域长度大于0，则可以坐人
                    if (dis > 0) {
                        // 当前空闲区域能产生的最大社交距离
                        int curSeatDis = dis / 2 - (dis % 2 == 0 ? 1 : 0);
                        // 当前空闲区域中具备最大社交距离的位置
                        int curSeatIdx = left + curSeatDis + 1;

                        // 保留最优解
                        if (curSeatDis > bestSeatDis) {
                            bestSeatDis = curSeatDis;
                            bestSeatIdx = curSeatIdx;
                        }
                    }

                    left = right;
                }

                // 如果最后一个座位，即第 seatNum - 1 号座位没有坐人的话，比如 1 0 0 0 1 0 0 0 0，此时最后一段空闲区域是没有右边界的，需要特殊处理
                if (seatIdx.get(seatIdx.size() - 1) < seatNum - 1) {
                    // 此时可以直接坐到第 seatNum - 1 号座位，最大社交距离为 curSeatDis
                    int curSeatDis = seatNum - 1 - seatIdx.get(seatIdx.size() - 1) - 1;
                    int curSeatIdx = seatNum - 1;

                    // 保留最优解
                    if (curSeatDis > bestSeatDis) {
                        bestSeatIdx = curSeatIdx;
                    }
                }

                // 如果能坐人，则将坐的位置加入seatIdx中
                if (bestSeatIdx > 0) {
                    seatIdx.add(bestSeatIdx);
                    seatIdx.sort((a, b) -> a - b);
                }

                // 假设当前人就是最后一个人，那么无论当前人是否能坐进去，都更新lastSeatIdx = bestSeatIdx
                lastSeatIdx = bestSeatIdx;
            }
        }

        return lastSeatIdx;
    }
}
