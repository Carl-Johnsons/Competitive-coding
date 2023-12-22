@echo off
setlocal enabledelayedexpansion

:askProblem
cls
echo Name of the problem you just solved ?
set /p problem_name="Problem name: "

:askPlatform
echo You solved the problem named "!problem_name!" in ...
echo 1. Codeforces
echo 2. Leetcode
echo 3. Kattis
echo 0. Back
set /p option="Option: "

set commit=solved "!problem_name!" in
if "!option!" == "1" (
    set commit=!commit! Codeforces
) else (
    if "!option!" == "2" (
        set commit=!commit! Leetcode
    ) else (
        if "!option!" == "3" (
            set commit=!commit! Kattis
        ) else (
            if "!option!" == "0" (
                goto askProblem
            ) else (
                echo "Invalid option. Please choose 1, 2, 3 or 0."
                goto askPlatform
            )
        )
    )
)
git add .
git commit -m "!commit!"
git push origin main