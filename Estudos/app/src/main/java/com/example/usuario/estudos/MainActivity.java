package com.example.usuario.estudos;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends FragmentActivity{
    private Toolbar tb1;
    private Drawer drawerLeft;
    private AccountHeader headerLeft;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb1= (Toolbar) findViewById(R.id.tb1);

        //Fragment

        if(savedInstanceState ==null) {
            fragment0 frag0 = new fragment0();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.layoutFrag,frag0);
            ft.commit();
        }
        //HeaderLeaft do Drawer
        headerLeft = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withThreeSmallProfileImages(false)
                .withHeaderBackground(R.drawable.fundoamarelo)
                .addProfiles(
                        new ProfileDrawerItem().withName("Pessoa1").withEmail("Pessoa1@email.com").withIcon(R.drawable.riven),
                        new ProfileDrawerItem().withName("Pessoa2").withEmail("Pessoa2@email.com").withIcon(R.drawable.fiora),
                        new ProfileDrawerItem().withName("Pessoa3").withEmail("Pessoa3@email.com").withIcon(R.drawable.riven),
                          new ProfileDrawerItem().withName("Pessoa4").withEmail("Pessoa4@email.com").withIcon(R.drawable.yasuo)
                )
                .build();

        //DrawerLeft
        drawerLeft = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(tb1)
                .withDisplayBelowStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(0)
                .withAccountHeader(headerLeft)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                     @Override
                     public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                         switch (position){
                             case 1:
                                 fragment0 frag0 =(fragment0) new fragment0();
                                 FragmentTransaction ft = fm.beginTransaction();
                                 ft.replace(R.id.layoutFrag,frag0);
                                 ft.commit();
                                 break;
                             case 2:
                                 fragment1 frag1 =(fragment1) new fragment1();
                                 ft = fm.beginTransaction();
                                 ft.replace(R.id.layoutFrag,frag1);
                                 ft.commit();
                                 break;
                             case 3:
                                 fragment2 frag2 =(fragment2) new fragment2();
                                 ft = fm.beginTransaction();
                                 ft.replace(R.id.layoutFrag,frag2);
                                 ft.commit();
                                 break;
                             case 5:
                                 finish();
                         }
                         return false;
                     }
                 })
                 .build();
                drawerLeft.addItem(new PrimaryDrawerItem().withIcon(R.drawable.iconecasinha).withName("Home"));
                drawerLeft.addItem(new PrimaryDrawerItem().withIcon(R.drawable.iconerelogio).withName("Agendar"));
                drawerLeft.addItem(new PrimaryDrawerItem().withIcon(R.drawable.iconeextras).withName("Extras"));
                drawerLeft.addItem(new DividerDrawerItem());
                drawerLeft.addItem(new PrimaryDrawerItem().withIcon(R.drawable.iconeconfig).withName("Sair"));
    }
}
