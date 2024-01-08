 1 < m:
                    next_row_hp = currentHP[i][j] + dungeon[i + 1][j]
                    lossedHP = 0 if currentHP[i][j] >= 0 else next_row_hp
                    if next_row_hp + lossedHP < minHP[i + 1][j]:
                        currentHP[i + 1][j] = next_row_hp
                        minHP[i + 1][j] = next_row_hp + lossedHP