#include <stdio.h>
#include <string.h>

int main()
{
    int test_case;
    char initial_position_of_ferry[6] = "left";
    scanf("%d", &test_case);
    while (test_case)
    {
        int length_of_ferry, count = 0, total_length = 0, number_of_cars, length_of_car[10] = {0};
        char position_of_car[10][6] = {0};
        test_case--;
        scanf("%d %d", &length_of_ferry, &number_of_cars);
        for (int i = 0; i < number_of_cars; i++)
        {
            scanf("%d", &length_of_car[i]);
            scanf("%s", &position_of_car[i]);
            fflush(stdin);
        }
        length_of_ferry *= 100;
        for (int i = 0; i < number_of_cars; i++)
        {
            if ((strncmp(position_of_car[i], initial_position_of_ferry, 5) == 0) && total_length < length_of_ferry)
            {
                total_length += length_of_car[i];
                if (total_length > length_of_ferry)
                {
                    total_length = 0;
                    i--;
                    if (strncmp(initial_position_of_ferry, "left", 4) == 0)
                        strcpy(initial_position_of_ferry, "right");
                    else if (strncmp(initial_position_of_ferry, "right", 5) == 0)
                        strcpy(initial_position_of_ferry, "left");
                    count++;
                }
            }
            else
            {
                i--;
                if (strncmp(initial_position_of_ferry, "left", 4) == 0)
                    strcpy(initial_position_of_ferry, "right");
                else if (strncmp(initial_position_of_ferry, "right", 5) == 0)
                    strcpy(initial_position_of_ferry, "left");
                total_length = 0;
                count++;
            }
        }
        count++;
        printf("%d", count);
        if (test_case >= 1)
            printf("\n");
    }
}