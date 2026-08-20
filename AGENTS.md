# ServerChest - Minecraft mod 1.21.1

## Основное

Майнкрафт мод добавляющий Серверный сундук (Server Chest) с общим доступом для всех игроков.
Все вещи сохраняются на один мир, где находится сам мод.

> Minecraft Mod Loader: `NeoForge 21.1.244`
> Minecraft Version: `1.21.1`
> Supported Languages: `English` and `Russian`

Мод должен полностью функцианировать с модом `/co i` то есть `CoreProtectNeo` и со всем списком модов из [ListMods](/ListMods.txt)

Также сундук не должен работать для воронок, жёлоб из мода `Create` и т.п. Только игрок должен забирать предметы из сундука.

## Рецепт сундука и текстура

Рецепт серверного сундука состоит из:
- 3-х эндерняка
- 2 обсидиана
- 2 Око эндера
- 1 эндер сундук
- 1 обычный сундук

```text
EEE
OCO
YDY
```

- `E` — `minecraft:end_stone`
- `O` — `minecraft:obsidian`
- `C` — `minecraft:chest`
- `Y` — `minecraft:ender_eye`
- `D` — `minecraft:ender_chest`

Текстуры блока находятся в [textures](/textures/)
Для верхней текстуры использовать [Top](/textures/ServerChest_Top.png)
Для нижней текстуры использовать [Bottom](/textures/ServerChest_Bottom.png)
Все боковые текстуры заполнить одной текстурой [Side](/textures/ServerChest_Side.png)

## Настройки самого блока

Настройки блока взять полностью из `minecraft:ender_chest`
Блок не должен раскрывать прямо как Эндер сундук, он должен просто открываться как бочка, но без звука.
Блок должен стакаться в 64 блока.
Окно на 27 слота.

Если сломать блок:
- Вещи остаются в общем серверном хранилище, даже те, который ранее закинул игрок в сам сундук.

## Сборка и запуск

Проект собирается Gradle-врапером (ничего ставить не нужно, кроме JDK 21):

```
./gradlew build        # собрать jar (build/libs/)
./gradlew runClient    # запустить клиент для теста
./gradlew runServer    # запустить dedicated-сервер для теста
```

Шаблон проекта — официальный NeoForge MDK на **ModDevGradle** (НЕ NeoGradle): https://github.com/neoforged/MDK