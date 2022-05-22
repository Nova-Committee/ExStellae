# Ex Stellae

*Gather resources from nothingness.*

**Ex Stellae** is a Minecraft mod that added in ways to gather resources from literally nothing. It is heavily inspired by [Ex Nihilo](https://www.curseforge.com/minecraft/mc-mods/ex-nihilo), but is greatly simplified and eased in my own thoughts.

For now it is not yet completed and lacks of bunch of planned features, but it is being actively maintained. Stay tuned for more new contents!

Requires [Architectury API](https://www.curseforge.com/minecraft/mc-mods/architectury-api).

### Customization

Since 0.1.0-snapspot+build.202205211055, the mod provides the possibility to define new sieve recipes via JSON.

Here is an example (as a recipe) :
```json
{
  "type": "exstellae:sieve",
  "input": {
    "item": "example:sandy_sand"
  },
  "lootTable": "example:path/to/your/loot_table",
  "outputItem": "example:blazing_blaze",
  "outputAmount": "2"
}
```
Once you try to right-click the sieve with the example:sandy_sand, loots from the loot table will be generated and dropped on the ground, together with the output stack.
