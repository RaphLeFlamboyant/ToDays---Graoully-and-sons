package com.ggj16.days.gamegenerator.modules;

import com.badlogic.gdx.math.Vector2;
import com.ggj16.days.controller.CharacterController;
import com.ggj16.days.controller.ElementController;
import com.ggj16.days.controller.ToDaysController;
import com.ggj16.days.model.InteractEventModel;
import com.ggj16.days.model.InteractModel;
import com.ggj16.days.model.ToDaysWorld;
import com.ggj16.days.screen.ToDaysScreen;
import com.ggj16.days.scripts.ActionScript;
import com.ggj16.days.scripts.uglypackage.BathroomActionScript;
import com.ggj16.days.scripts.uglypackage.BedActionScript;
import com.ggj16.days.scripts.uglypackage.DesktopActionScript;
import com.ggj16.days.scripts.uglypackage.KitchenActionScript;
import com.ggj16.days.scripts.uglypackage.MainMirrorActionScript;
import com.ggj16.days.scripts.uglypackage.MirrorSecretActionScript;
import com.ggj16.days.scripts.uglypackage.NoActionScript;
import com.ggj16.days.scripts.uglypackage.PassageLitActionScript;
import com.ggj16.days.scripts.uglypackage.SecuCouloirActionScript;
import com.ggj16.days.scripts.uglypackage.ShowerActionScript;
import com.ggj16.days.scripts.uglypackage.ToiletActionScript;
import com.ggj16.days.scripts.uglypackage.ToiletDoorActionScript;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.ToDaysRenderer;
import com.ggj16.days.view.interact.InteractStaticView;

/**
 * Created by Reborn Portable on 30/01/2016.
 */
public class UglyElementGenerator {
    ToDaysController controller;
    ToDaysRenderer renderer;
    ToDaysWorld world;
    ToDaysScreen owner;

    public UglyElementGenerator(ToDaysController controller, ToDaysRenderer renderer, ToDaysWorld world, ToDaysScreen owner) {
        this.controller = controller;
        this.renderer = renderer;
        this.world = world;
        this.owner = owner;
    }

    public void generateElements()
    {
        bed();
        secuCouloir();
        mainMiroir();
        kitchen();
        bathroom();
        shower();
        desktop();
        passageLit();
        doorBathroom();
        doorDesktop();
        doorToilets();
        mirrorSecret();
        toilet();
    }

    private void bed()
    {
        ElementController bed = new ElementController();
        bed.setEltID(0);
        bed.setColides(true);
        bed.setVirtualCoordinates(402, 407);
        bed.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(bed);

        InteractStaticView bedV = new InteractStaticView(null);
        bedV.setInteractID(0);
        bedV.setTextureRegionName("empty");
        bedV.setPosition(402 * 100, 407 * 100);
        renderer.getInteracts().add(bedV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new BedActionScript(controller, world, renderer, owner, 0);
        im.setId(0);

        InteractEventModel iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(402, 407);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(402, 407);
        iem.getListIds().add(1);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 3);
        iem.setViewName("empty");
        iem.setCoordinates(402, 407);
        iem.getListIds().add(11);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 4);
        iem.setViewName("empty");
        iem.setCoordinates(402, 407);
        iem.getListIds().add(24);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 5);
        iem.setViewName("empty");
        iem.setCoordinates(402, 407);
        iem.getListIds().add(28);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void secuCouloir()
    {
        ElementController secuCouloir = new ElementController();
        secuCouloir.setEltID(1);
        secuCouloir.setColides(false);
        secuCouloir.setIntercepts(false);
        secuCouloir.setVirtualCoordinates(405, 409);
        secuCouloir.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(secuCouloir);

        InteractStaticView secuCouloirV = new InteractStaticView(null);
        secuCouloirV.setInteractID(1);
        secuCouloirV.setTextureRegionName("empty");
        secuCouloirV.setPosition(405 * 100, 409 * 100);
        renderer.getInteracts().add(secuCouloirV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new SecuCouloirActionScript(controller, world, renderer, owner, 1);
        im.setId(1);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("empty");
        iem.setCoordinates(405, 409);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(405, 409);
        iem.getListIds().add(1);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(405, 409);
        iem.getListIds().add(2);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 3);
        iem.setViewName("empty");
        iem.setCoordinates(0, 0);
        iem.getListIds().add(3);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void mainMiroir()
    {
        ElementController miroir = new ElementController();
        miroir.setEltID(2);
        miroir.setColides(true);
        miroir.setIntercepts(false);
        miroir.setVirtualCoordinates(403, 406);
        //miroir.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(miroir);

        InteractStaticView miroirV = new InteractStaticView(null);
        miroirV.setInteractID(2);
        miroirV.setTextureRegionName("empty");
        miroirV.setPosition(403 * 100, 406 * 100);
        renderer.getInteracts().add(miroirV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new MainMirrorActionScript(controller, world, renderer, owner, 2);
        im.setId(2);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("empty");
        iem.setCoordinates(403, 406);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(403, 406);
        iem.getListIds().add(1);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(403, 406);
        iem.getListIds().add(24);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void kitchen()
        {
        ElementController kitchen = new ElementController();
        kitchen.setEltID(3);
        kitchen.setColides(true);
        kitchen.setIntercepts(false);
        kitchen.setVirtualCoordinates(408, 405);
        kitchen.getFulls().add(new Vector2(0, 1));
        kitchen.getFulls().add(new Vector2(1, 0));
        controller.getMap().getElements().add(kitchen);

        InteractStaticView kitchenV = new InteractStaticView(null);
        kitchenV.setInteractID(3);
        kitchenV.setTextureRegionName("empty");
        kitchenV.setPosition(408 * 100, 405 * 100);
        renderer.getInteracts().add(kitchenV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new KitchenActionScript(controller, world, renderer, owner, 3);
        im.setId(3);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(3);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(4);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 3);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(5);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 4);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(7);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 5);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(9);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 6);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(24);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 7);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(26);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 8);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(29);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 9);
        iem.setViewName("empty");
        iem.setCoordinates(408, 405);
        iem.getListIds().add(30);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void bathroom()
    {
        ElementController bathroom = new ElementController();
        bathroom.setEltID(4);
        bathroom.setColides(false);
        bathroom.setIntercepts(true);
        bathroom.setVirtualCoordinates(403, 413);
        //bathroom.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(bathroom);

        InteractStaticView bathroomV = new InteractStaticView(null);
        bathroomV.setInteractID(4);
        bathroomV.setTextureRegionName("empty");
        bathroomV.setPosition(403 * 100, 413 * 100);
        renderer.getInteracts().add(bathroomV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new BathroomActionScript(controller, world, renderer, owner, 4);
        im.setId(4);

        InteractEventModel iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(403, 413);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(0, 0);
        iem.getListIds().add(6);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }


    private void shower()
    {
        ElementController shower = new ElementController();
        shower.setEltID(5);
        shower.setColides(true);
        shower.setIntercepts(false);
        shower.setVirtualCoordinates(404, 413);
        //shower.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(shower);

        InteractStaticView showerV = new InteractStaticView(null);
        showerV.setInteractID(5);
        showerV.setTextureRegionName("empty");
        showerV.setPosition(404 * 100, 413 * 100);
        renderer.getInteracts().add(showerV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new ShowerActionScript(controller, world, renderer, owner, 5);
        im.setId(5);

        InteractEventModel iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(404, 413);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(404, 413);
        iem.getListIds().add(8);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 3);
        iem.setViewName("empty");
        iem.setCoordinates(404, 413);
        iem.getListIds().add(7);
        iem.setWeight(1);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 4);
        iem.setViewName("empty");
        iem.setCoordinates(404, 413);
        iem.getListIds().add(24);
        iem.setWeight(1);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 5);
        iem.setViewName("empty");
        iem.setCoordinates(404, 413);
        iem.getListIds().add(25);
        iem.setWeight(1);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void desktop()
    {
        ElementController desktop = new ElementController();
        desktop.setEltID(6);
        desktop.setColides(true);
        desktop.setIntercepts(false);
        desktop.setVirtualCoordinates(413, 413);
        desktop.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(desktop);

        InteractStaticView desktopV = new InteractStaticView(null);
        desktopV.setInteractID(6);
        desktopV.setTextureRegionName("empty");
        desktopV.setPosition(413 * 100, 413 * 100);
        renderer.getInteracts().add(desktopV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new DesktopActionScript(controller, world, renderer, owner, 6);
        im.setId(6);

        InteractEventModel iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(413, 413);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(413, 413);
        iem.getListIds().add(10);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 3);
        iem.setViewName("empty");
        iem.setCoordinates(413, 413);
        iem.getListIds().add(24);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 4);
        iem.setViewName("empty");
        iem.setCoordinates(413, 413);
        iem.getListIds().add(27);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }


    private void passageLit()
    {
        ElementController passageLit = new ElementController();
        passageLit.setEltID(7);
        passageLit.setColides(false);
        passageLit.setIntercepts(false);
        passageLit.setVirtualCoordinates(0, 0);
        passageLit.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(passageLit);

        InteractStaticView passageLitV = new InteractStaticView(null);
        passageLitV.setInteractID(7);
        passageLitV.setTextureRegionName("empty");
        passageLitV.setPosition(0 * 100, 0 * 100);
        renderer.getInteracts().add(passageLitV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new PassageLitActionScript(controller, world, renderer, owner, 7);
        im.setId(7);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("empty");
        iem.setCoordinates(0, 0);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(404, 409);
        iem.getListIds().add(10);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(0, 0);
        iem.getListIds().add(11);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void doorBathroom()
    {
        ElementController doorBathroom = new ElementController();
        doorBathroom.setEltID(8);
        doorBathroom.setColides(true);
        doorBathroom.setIntercepts(false);
        doorBathroom.setVirtualCoordinates(403, 411);
        //doorBathroom.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(doorBathroom);

        InteractStaticView doorBathroomV = new InteractStaticView(null);
        doorBathroomV.setInteractID(8);
        doorBathroomV.setTextureRegionName("door");
        doorBathroomV.setPosition(403 * 100, 411 * 100);
        doorBathroomV.setOffset(-21, -3);
        renderer.getInteracts().add(doorBathroomV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);
        AssetsLoader.loadTextureRegion("Elements/door.png", "door", 0, 0, 137, 103);

        InteractModel im = new InteractModel();
        ActionScript as = new NoActionScript(controller, world, renderer, owner, 8);
        im.setId(8);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("door");
        iem.setCoordinates(403, 411);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(0, 0);
        iem.getListIds().add(3);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void doorDesktop()
    {
        ElementController doorBathroom = new ElementController();
        doorBathroom.setEltID(9);
        doorBathroom.setColides(true);
        doorBathroom.setIntercepts(false);
        doorBathroom.setVirtualCoordinates(410, 411);
        //doorBathroom.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(doorBathroom);

        InteractStaticView doorBathroomV = new InteractStaticView(null);
        doorBathroomV.setInteractID(9);
        doorBathroomV.setTextureRegionName("door");
        doorBathroomV.setPosition(410 * 100, 411 * 100);
        doorBathroomV.setOffset(-24, -3);
        renderer.getInteracts().add(doorBathroomV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);
        AssetsLoader.loadTextureRegion("Elements/door.png", "door", 0, 0, 137, 103);

        InteractModel im = new InteractModel();
        ActionScript as = new NoActionScript(controller, world, renderer, owner, 9);
        im.setId(9);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("door");
        iem.setCoordinates(410, 411);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(0, 0);
        iem.getListIds().add(9);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void doorToilets()
    {
        ElementController doorBathroom = new ElementController();
        doorBathroom.setEltID(10);
        doorBathroom.setColides(true);
        doorBathroom.setIntercepts(false);
        doorBathroom.setVirtualCoordinates(407, 411);
        //doorBathroom.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(doorBathroom);

        InteractStaticView doorBathroomV = new InteractStaticView(null);
        doorBathroomV.setInteractID(10);
        doorBathroomV.setTextureRegionName("door");
        doorBathroomV.setPosition(407 * 100, 411 * 100);
        doorBathroomV.setOffset(-22, -3);
        renderer.getInteracts().add(doorBathroomV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);
        AssetsLoader.loadTextureRegion("Elements/door.png", "door", 0, 0, 137, 103);

        InteractModel im = new InteractModel();
        ActionScript as = new ToiletDoorActionScript(controller, world, renderer, owner, 10);
        im.setId(10);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("door");
        iem.setCoordinates(407, 411);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("door");
        iem.setCoordinates(407, 411);
        iem.getListIds().add(24);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(0, 0);
        iem.getListIds().add(29);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }

    private void mirrorSecret()
    {
        ElementController mirrorSecret = new ElementController();
        mirrorSecret.setEltID(11);
        mirrorSecret.setColides(true);
        mirrorSecret.setIntercepts(false);
        mirrorSecret.setVirtualCoordinates(412, 406);
        //mirrorSecret.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(mirrorSecret);

        InteractStaticView mirrorSecretV = new InteractStaticView(null);
        mirrorSecretV.setInteractID(11);
        mirrorSecretV.setTextureRegionName("mirrorSecret");
        mirrorSecretV.setPosition(412 * 100, 406 * 100);
        mirrorSecretV.setOffset(2, -75);
        renderer.getInteracts().add(mirrorSecretV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);
        AssetsLoader.loadTextureRegion("Elements/mirrorSecret.png", "mirrorSecret", 0, 0, 99, 186);

        InteractModel im = new InteractModel();
        ActionScript as = new MirrorSecretActionScript(controller, world, renderer, owner, 11);
        im.setId(11);

        InteractEventModel iem = new InteractEventModel(as, 0);
        iem.setViewName("mirrorSecret");
        iem.setCoordinates(412, 406);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 1);
        iem.setViewName("mirrorSecret");
        iem.setCoordinates(412, 406);
        iem.getListIds().add(30);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(0 , 0 );
        iem.getListIds().add(31);
        im.getListEvents().add(iem);

        world.getListInteractModel().add(im);
    }



    private void toilet()
    {
        ElementController toilet = new ElementController();
        toilet.setEltID(12);
        toilet.setColides(true);
        toilet.setIntercepts(false);
        toilet.setVirtualCoordinates(407, 415);
        //toilet.getFulls().add(new Vector2(0, 1));
        controller.getMap().getElements().add(toilet);

        InteractStaticView toiletV = new InteractStaticView(null);
        toiletV.setInteractID(12);
        toiletV.setTextureRegionName("empty");
        toiletV.setPosition(407 * 100, 415 * 100);
        renderer.getInteracts().add(toiletV);
        AssetsLoader.loadTextureRegion("Elements/empty.png", "empty", 0, 0, 100, 100);


        InteractModel im = new InteractModel();
        ActionScript as = new ToiletActionScript(controller, world, renderer, owner, 12);
        im.setId(12);

        InteractEventModel iem = new InteractEventModel(as, 1);
        iem.setViewName("empty");
        iem.setCoordinates(407, 415);
        iem.getListIds().add(0);
        im.getListEvents().add(iem);

        iem = new InteractEventModel(as, 2);
        iem.setViewName("empty");
        iem.setCoordinates(407, 415);
        iem.getListIds().add(28);
        im.getListEvents().add(iem);


        world.getListInteractModel().add(im);
    }
}
