package com.enderdevelopment.autoplacer.client.gui;

import com.enderdevelopment.autoplacer.client.AutoPlacer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.gui.widget.CheckboxWidget;
import net.minecraft.text.Text;

public class AutoPlacerScreen extends Screen {
    private final AutoPlacer autoPlacer;
    private SliderWidget horizontalRadiusSlider;
    private SliderWidget verticalHeightSlider;
    private SliderWidget blocksPerTickSlider;
    private CheckboxWidget rotateCheckbox;

    public AutoPlacerScreen(AutoPlacer autoPlacer) {
        super(Text.literal("AutoPlacer Config"));
        this.autoPlacer = autoPlacer;
    }

    @Override
    protected void init() {
        super.init();

        horizontalRadiusSlider = new SliderWidget(this.width / 2 - 100, 50, 200, 20, Text.literal("Horizontal Radius: "), Text.literal("")) {
            @Override
            protected void updateMessage() {
                setMessage(Text.literal("Horizontal Radius: " + (int) (value * 31 + 1)));
            }
        };
        addDrawableChild(horizontalRadiusSlider);

        verticalHeightSlider = new SliderWidget(this.width / 2 - 100, 80, 200, 20, Text.literal("Vertical Height: "), Text.literal("")) {
            @Override
            protected void updateMessage() {
                setMessage(Text.literal("Vertical Height: " + (int) (value * 31 + 1)));
            }
        };
        addDrawableChild(verticalHeightSlider);

        blocksPerTickSlider = new SliderWidget(this.width / 2 - 100, 110, 200, 20, Text.literal("Blocks Per Tick: "), Text.literal("")) {
            @Override
            protected void updateMessage() {
                setMessage(Text.literal("Blocks Per Tick: " + (int) (value * 63 + 1)));
            }
        };
        addDrawableChild(blocksPerTickSlider);

        rotateCheckbox = new CheckboxWidget(this.width / 2 - 100, 140, 200, 20, Text.literal("Rotate Enabled"), false);
        addDrawableChild(rotateCheckbox);

        addDrawableChild(ButtonWidget.builder(Text.literal("Save"), button -> {
            autoPlacer.setConfig(
                    (int) (horizontalRadiusSlider.value * 31 + 1),
                    (int) (verticalHeightSlider.value * 31 + 1),
                    (int) (blocksPerTickSlider.value * 63 + 1),
                    rotateCheckbox.isChecked()
            );
            close();
        }).dimensions(this.width / 2 - 100, 170, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
    }
}