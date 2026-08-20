<div align="center">
  <img src="Server%20Chest.png" width="128" alt="Server Chest texture">

  # 📦 Server Chest

  **One Server Chest — one shared storage for every player in the world.**

  [![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-62B47A?style=flat-square&logo=minecraft&logoColor=white)](https://www.minecraft.net/)
  [![NeoForge](https://img.shields.io/badge/NeoForge-21.1.244-E1782C?style=flat-square)](https://neoforged.net/)
  [![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://adoptium.net/)
  [![Build](https://img.shields.io/github/actions/workflow/status/softboundless/ServerChest/build.yml?branch=main&style=flat-square&label=build)](https://github.com/softboundless/ServerChest/actions/workflows/build.yml)
  [![License](https://img.shields.io/badge/license-Softboundless%201.0-4C1?style=flat-square)](LICENSE)

  [English](#english) • [Русский](#russian)
</div>

<a id="english"></a>

## 🇬🇧 English

### ✨ About the mod

**Server Chest** adds a 27-slot server-wide chest. Every Server Chest placed in the same world opens the same storage, regardless of the player or dimension.

Items are stored in the world data and remain safe even if the last Server Chest is broken.

### 🧰 Features

- 🌍 one shared storage across the entire world, accessible from any dimension;
- 👥 the same inventory for every player;
- 💾 contents persist independently of placed blocks;
- 🔒 access is available only through the player interface;
- 🚫 hoppers, droppers, Create funnels and chutes cannot move items;
- 🔇 opens without a lid animation or sound;
- 📚 27 inventory slots;
- 🧱 block items stack up to 64;
- 🌐 English and Russian localization.

### 🛠 Recipe

| | | |
|:---:|:---:|:---:|
| End Stone | End Stone | End Stone |
| Obsidian | Chest | Obsidian |
| Eye of Ender | Ender Chest | Eye of Ender |

<details>
<summary>Item identifiers</summary>

```text
EEE
OCO
YDY

E — minecraft:end_stone
O — minecraft:obsidian
C — minecraft:chest
Y — minecraft:ender_eye
D — minecraft:ender_chest
```

</details>

### 📥 Installation

#### Requirements

- **Minecraft:** 1.21.1
- **Mod Loader:** NeoForge 21.1.244 or a newer compatible release for Minecraft 1.21.1
- **Java:** 21

#### Steps

1. Install NeoForge for Minecraft 1.21.1.
2. Download the mod JAR from the [Releases](../../releases) page.
3. Place the JAR in the `mods` folder on the server **and on every player's client**.
4. Start the game or server.

> [!IMPORTANT]
> Before removing the mod, move all valuable items from the shared storage into a regular chest. Always back up the world before updating the mod.

### 🔌 Compatibility

#### CoreProtectNeo

The mod supports container inspection through `/co i` and inventory rollbacks. History is recorded at the position of the specific Server Chest that a player used to open the shared storage.

As a result, inspecting another Server Chest does not combine the full history. When multiple players view the storage simultaneously, snapshots may overlap. This is a limitation of applying position-based logging to a single server-wide inventory.

#### Automation

Vanilla hoppers and droppers, as well as compatible automation systems including Create funnels and chutes, cannot access the inventory. Only a player using the chest interface can move items.

### 📄 License

The source code is distributed under the custom [Softboundless Mod License 1.0](LICENSE).

The license permits using, modifying, publishing, redistributing and including the mod in modpacks, subject to its terms. Please note that it contains a separate restriction for third-party modpacks whose title or primary branding contains **Freakland**, **Freak Land** or **Freak-Land**. The complete and legally authoritative terms are available in the [LICENSE](LICENSE) file.

---

<a id="russian"></a>

## 🇷🇺 Русский

### ✨ О моде

**Server Chest** добавляет серверный сундук на 27 слотов. Все установленные серверные сундуки в одном мире открывают одно и то же хранилище — независимо от игрока и измерения.

Предметы хранятся в данных мира и не пропадают, даже если сломать последний серверный сундук.

### 🧰 Возможности

- 🌍 общее хранилище на весь мир, доступное из любого измерения;
- 👥 единый инвентарь для всех игроков;
- 💾 сохранение содержимого независимо от установленных блоков;
- 🔒 доступ только через интерфейс игрока;
- 🚫 воронки, выбрасыватели, жёлобы и воронки из Create не могут перемещать предметы;
- 🔇 открытие без анимации крышки и без звука;
- 📚 окно на 27 слотов;
- 🧱 блок стакается по 64 штуки;
- 🌐 локализация на русский и английский языки.

### 🛠 Рецепт

| | | |
|:---:|:---:|:---:|
| Эндерняк | Эндерняк | Эндерняк |
| Обсидиан | Сундук | Обсидиан |
| Око Эндера | Эндер-сундук | Око Эндера |

<details>
<summary>Идентификаторы предметов</summary>

```text
EEE
OCO
YDY

E — minecraft:end_stone
O — minecraft:obsidian
C — minecraft:chest
Y — minecraft:ender_eye
D — minecraft:ender_chest
```

</details>

### 📥 Установка

#### Требования

- **Minecraft:** 1.21.1
- **Mod Loader:** NeoForge 21.1.244 или более новая совместимая версия для Minecraft 1.21.1
- **Java:** 21

#### Шаги

1. Установите NeoForge для Minecraft 1.21.1.
2. Скачайте JAR-файл мода со страницы [Releases](../../releases).
3. Поместите JAR-файл в папку `mods` на сервере **и у всех игроков**.
4. Запустите игру или сервер.

> [!IMPORTANT]
> Перед удалением мода перенесите ценные предметы из общего хранилища в обычный сундук. Всегда делайте резервную копию мира перед обновлением сборки.

### 🔌 Совместимость

#### CoreProtectNeo

Мод совместим с проверкой контейнеров через `/co i` и откатом изменений инвентаря. История записывается на координаты конкретного серверного сундука, через который игрок открыл общее хранилище.

Поэтому проверка другого серверного сундука не объединяет всю историю. При одновременном просмотре хранилища несколькими игроками возможны пересекающиеся снимки — это ограничение позиционного журналирования единого серверного инвентаря.

#### Автоматизация

Обычные воронки, выбрасыватели и совместимые системы автоматизации, включая воронки и жёлобы Create, не получают доступ к инвентарю. Предметы может перемещать только игрок через интерфейс сундука.

### 📄 Лицензия

Исходный код распространяется по пользовательской лицензии [Softboundless Mod License 1.0](LICENSE).

Она разрешает использование, изменение, публикацию, распространение и включение мода в сборки при соблюдении её условий. Обратите внимание: лицензия содержит отдельное ограничение для сторонних модпаков, в названии или основном брендинге которых используется **Freakland**, **Freak Land** или **Freak-Land**. Полный и юридически значимый текст находится в файле [LICENSE](LICENSE).
