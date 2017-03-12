package com.darwindeveloper.wcviewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.darwindeveloper.wcviewpagerindicatorlibrary.WCViewPagerIndicator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }


    /**
     * adaptador para nuextro wcviewpager
     */
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {

            //usaremos la misma clase para todos los fragment solo cambiaremos el texto de cada fragment
            Fragment fragment = new PageFragment();
            Bundle args = new Bundle();//para pasar datos al fragment
            args.putInt(PageFragment.PAGE, position + 1);//le sumamos 1 a la posicion para que el texto mostrado corresponda con el del indicador
            fragment.setArguments(args);//le pasamos los datos(numero de pagina) al fragment

            return fragment;
        }

        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return 5;//nuemro de paginas para nuestro wcviewpager
        }
    }
}
