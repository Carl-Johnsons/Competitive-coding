// https://codeforces.com/problemset/problem/144/A
#include <stdio.h>

int main()
{
    int max, min, arr[1000], num, time, temp, count = 0, max_location, min_location;
    scanf("%d", &num);
    for (int i = 0; i < num; i++)
    {
        scanf("%d", &arr[i]);
    }
    max = arr[0];
    min = arr[num - 1];
    for (int i = 0; i < num; i++)
    {
        if (max < arr[i])
        {
            max_location = i;
            max = arr[i];
        }
        if (min >= arr[i])
        {
            min = arr[i];
            min_location = i;
        }
    }
    while (1)
    {
        if (arr[0] == max && arr[num - 1] == min)
            break;
        for (int i = 0; i < num; i++)
        {
            if (arr[0] != max)
            {
                if (max_location - 1 == min_location)
                    min_location++;
                temp = arr[max_location - 1];
                arr[max_location - 1] = arr[max_location];
                arr[max_location] = temp;
                max_location--;
                break;
            }
            else if (arr[num - 1] != min)
            {
                temp = arr[min_location];
                arr[min_location] = arr[min_location + 1];
                arr[min_location + 1] = temp;
                min_location++;
                break;
            }
        }
        count++;
    }
    printf("%d", count);
}