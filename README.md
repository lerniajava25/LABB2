# Raytracer

Det här är en enkel raytracer byggd i Java. Programmet skickar ut rays från
en kamera och kontrollerar om de träffar objekt i scenen. Just nu finns en
`Sphere` och en `Triangle`.

När programmet körs renderas scenen till en PNG-bild som sparas som
`image.png`.

## Klasser

- `Vector3D` används för punkter och vektorer i 3D.
- `Color` används för färger.
- `Ray` representerar en stråle med en startpunkt och en riktning.
- `Shape` är ett interface som alla former implementerar.
- `Sphere` är en sfär som kan träffas av en ray.
- `Triangle` är en triangel som kan träffas av en ray.
- `Scene` innehåller alla former i en `List<Shape>`.
- `Renderer` skickar rays genom bilden och färglägger pixlar.
- `Main` startar programmet och sparar bilden.

## Hur lägger man till en ny Shape?

Följande exempel visar hur man kan lägga till en ny form, till exempel `Box`.
`Box` är bara ett exempel och är inte implementerad i koden just nu.
Skapa en ny klass som implementerar `Shape`:

```java
public class Box implements Shape {
    @Override
    public boolean hit(Ray ray) {
        return false;
    }
}
```

Skriv sedan den egna beräkningen i `hit`. Returnera `true` om rayen träffar
formen och `false` om den inte träffar.

Lägg sedan till formen i `Main`:

```java
Box box = new Box();
scene.addShape(box);
```

Man behöver inte ändra `Scene` eller `Renderer`. De arbetar redan med
`Shape`, så olika former kan användas på samma sätt.

När `Box` har implementerats kan den läggas till i scenen på samma sätt som
`Sphere` och `Triangle`. `Scene` och `Renderer` behöver inte ändras eftersom
de arbetar med `Shape`-interfacet i stället för med en specifik form.



## Köra programmet

Programmet körs från `Main`. Bilden sparas i projektmappen som:

```text
image.png
```
