n = int(input())
inp_str = input().split()
cap_sac = sorted(list(map(int, inp_str)))
m = int(input())
inp_str = input().split()
o_cam_dien = sorted(list(map(int, inp_str)))

counter = 0
i = 0
j = 0
while i < n and j < m:
    if abs(cap_sac[i] - o_cam_dien[j]) <= 1:
        counter += 1
        i += 1
        j += 1
    else:
        if cap_sac[i] > o_cam_dien[j]:
            j += 1
        else:
            i += 1
print(counter)
