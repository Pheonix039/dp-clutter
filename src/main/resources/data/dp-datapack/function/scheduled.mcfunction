execute as @e at @s if data entity @s active_effects[{id:"dp-clutter:dp_aoe"}] run function dp-datapack:particles
# tellraw @a[tag=Deadpool] {"text":"the teamup nobody asked for!","color":"red"}
schedule function dp-datapack:scheduled 10t replace