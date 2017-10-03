package com.ggj16.days.view.character;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.ggj16.days.utils.AssetsLoader;
import com.ggj16.days.view.EDirection;
import com.ggj16.days.view.drawable.ITexturedElement;

/**
 * Created by Reborn Portable on 29/01/2016.
 */
public class CharacterView implements ITexturedElement {
    private String standUp;
    private String standDown;
    private String standRight;
    private String standLeft;
    private String walkUp;
    private String walkDown;
    private String walkRight;
    private String walkLeft;

    private EDirection direction = EDirection.DOWN;

    private Vector2 offset = new Vector2();
    private Vector2 position = new Vector2();
    private Vector2 targetPosition = new Vector2();
    private float timelap = 0;
    private boolean isMoving;
    
    public CharacterView (String standUp, String standDown, String standRight, String standLeft,
                          String walkUp, String walkDown, String walkRight, String walkLeft) {
        super();
        
        this.walkUp = walkUp;
        this.walkDown = walkDown;
        this.walkLeft = walkLeft;
        this.walkRight = walkRight;
        this.standUp = standUp;
        this.standDown = standDown;
        this.standLeft = standLeft;
        this.standRight = standRight;
    }

    public void update(float delta)
    {
        float speed = 400; //unit (px) per sec
        if (targetPosition.equals(position)) {
            this.isMoving = false;
            return;
        }

        this.isMoving = true;

        if (targetPosition.x < position.x) {
            this.direction = EDirection.LEFT;
            position.x = (-speed * delta + position.x) <= targetPosition.x ? targetPosition.x : (-speed * delta + position.x);
        }
        if (targetPosition.x > position.x){
            this.direction = EDirection.RIGHT;
            position.x = (speed * delta + position.x) >= targetPosition.x ? targetPosition.x : (speed * delta + position.x);
        }
        if (targetPosition.y < position.y) {
            this.direction = EDirection.UP;
            position.y = (-speed * delta + position.y) <= targetPosition.y ? targetPosition.y : (-speed * delta + position.y);
        }
        if (targetPosition.y > position.y) {
            this.direction = EDirection.DOWN;
            position.y = (speed * delta + position.y) >= targetPosition.y ? targetPosition.y : (speed * delta + position.y);
        }
    }

    public boolean reachedTarget()
    {
        return targetPosition.equals(position);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    public Vector2 getOffset() {
        return offset;
    }

    public void setOffset(float x, float y) {
        offset.x = x;
        offset.y = y;
    }

    @Override
    public EDirection getDirection() {
        return direction;
    }

    @Override
    public void setDirection(EDirection dir) {
        direction = dir;
    }

    public Vector2 getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(float x, float y) {

        this.targetPosition.x = x;
        targetPosition.y = y;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }



    @Override
    public TextureRegion getTextureRegion(float delta) {
        timelap += delta;
        String animName;

        switch (this.direction)
        {
            case UP:
                animName = isMoving ? walkUp : standUp;
                break;
            case DOWN:
                animName = isMoving ? walkDown : standDown;
                break;
            case LEFT:
                animName = isMoving ? walkLeft : standLeft;
                break;
            case RIGHT:
                animName = isMoving ? walkRight : standRight;
                break;
            default:
                animName = standDown;
                break;
        }

        return (AssetsLoader.getAnimation(animName).getKeyFrame(timelap));
    }
}
