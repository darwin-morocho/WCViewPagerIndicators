# WCViewPagerIndicators
Es una libreria android que permite a los desarrolladores tener un viewpager con el atributo layout_height="wrap_content", ademas  de incluir en la parte inferior un indicador de paginas (API 16 o superior)..

##Live demo
usted puede ver una aplicacion demo en el siguiente enlace https://appetize.io/app/3ee65vjy0rkn8p3xph7aytbh4g

##Capturas de pantalla
| demo 1 | demo 2 | demo 3 |
| --- | --- | --- |
| ![](https://cloud.githubusercontent.com/assets/15864336/23829170/144e0a5a-06b8-11e7-86d5-f7c787eb7678.png) | ![](https://cloud.githubusercontent.com/assets/15864336/23829171/14816774-06b8-11e7-8c20-e4c64f2dfb3b.png) | ![](https://cloud.githubusercontent.com/assets/15864336/23829172/14863d58-06b8-11e7-9e51-dd3793528bc7.png) |

##Instalación
#Instalación
Este proyecto fue modificado y mejorado en (ingrese con su cuenta de google para observar la demo) https://github.com/MorochoRochaDarwin/mr-teacher
en su archivo /app/build.gradle
```
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
       compile 'com.github.MorochoRochaDarwin:WCViewPagerIndicators:3.0'
}
```

##Agregar la vista a su Layout
```xml
  <com.darwindeveloper.wcviewpager.WCViewPagerIndicator
          android:id="@+id/wcviewpager"
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
         />
```
###Diseño completo
```xml
  <com.darwindeveloper.wcviewpager.WCViewPagerIndicator
        android:id="@+id/wcviewpager"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:indicatorSelectedColor="@color/colorPrimary"
        app:indicatorsColor="#d2d2d2"
        app:numberSelectedColor="#fff"
        app:numbersColor="@color/colorPrimary"
        app:showNumbers="true" />

```

#En sus Actividades o Fragments
Inicialice la vista y capture los cambios en el viewpager
```java
 //inicializamos la vista
        final WCViewPagerIndicator wcViewPagerIndicator = (WCViewPagerIndicator) findViewById(R.id.wcviewpager);
        //creamos un nuevo adpater
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        wcViewPagerIndicator.setAdapter(viewPagerAdapter);//aplicamos el adapter

        //obtenemos el viewpager y capturamos sus cambios en tiempo de ejecucuion
        wcViewPagerIndicator.getViewPager().addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //NOTA: las posiciones del viewpager inician en 0
                //cambiamos el indicador a la posicion del viewpager
                wcViewPagerIndicator.setSelectedindicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
```

Vea el ejemplo de muestra para mayor información




