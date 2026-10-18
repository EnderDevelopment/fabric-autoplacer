# AutoPlacer

AutoPlacer is a Fabric client utility module for Minecraft that automates block placement. It includes a user configuration GUI menu with four specific variables: a horizontal radius slider (range 1 to 32 blocks), a vertical height slider (range 1 to 32 blocks), a blocks-per-tick placement limit slider (range 1 to 64), and a rotate toggle checkbox. When activated, the mod scans a large 3D bounding box area around the player matching the radius settings on every game tick. If it finds empty air blocks or replaceable block states like tall grass or water, it instantly simulates a main-hand block placement packet using whatever block item the player is currently holding. If the rotate checkbox is enabled, it automatically forces player rotation packets toward the block face being placed to bypass anti-cheat checks. The mod enforces a strict placement limit matching the blocks-per-tick slider configuration to prevent network overflow or game desync.

## Install

1. Download the latest release from the [GitHub repository](https://github.com/enderdevelopment/autoplacer).
2. Place the downloaded JAR file in your Minecraft mods folder.
3. Launch Minecraft with the Fabric mod loader.

## Use

1. Launch Minecraft and load a world.
2. Open the AutoPlacer configuration GUI by using the command `/autoplacer` or through a mod menu if available.
3. Adjust the horizontal radius, vertical height, blocks-per-tick placement limit, and rotate toggle as desired.
4. Click "Save" to apply the settings.
5. Activate the mod by using the command `/autoplacer toggle` or through a mod menu if available.
6. The mod will now automatically place blocks in the specified area.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/a8a07b39-b1fb-465a-bf9a-e001bb41873b?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=a8a07b39-b1fb-465a-bf9a-e001bb41873b
