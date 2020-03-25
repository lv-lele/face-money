package com.bearhunting.cameraholder.utils.deserializer;

import com.bearhunting.cameraholder.exception.CustomException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.geolatte.geom.C2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.Point;
import org.geolatte.geom.PositionSequence;
import org.geolatte.geom.PositionSequenceBuilder;
import org.geolatte.geom.PositionSequenceBuilders;
import org.geolatte.geom.crs.CoordinateReferenceSystems;


/**
 * ClassName:HttpResultCode
 * Package:com.bearhunting.cameraholder.common
 * Description: 点反序列化
 * @date:2019/11/15 9:39
 * @author:lvlele@bearhunting.cn
 */
@Slf4j
public class PointDeserializer extends JsonDeserializer<Geometry<C2D>> {
    @Override
    public Geometry<C2D> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            ObjectCodec objectCodec = p.getCodec();
            JsonNode node = objectCodec.readTree(p);

            PositionSequenceBuilder<C2D> builder = PositionSequenceBuilders.variableSized(C2D.class);

            builder.add(node.get("lng").doubleValue(), node.get("lat").doubleValue());
            PositionSequence<C2D> positionSequence = builder.toPositionSequence();
            return new Point<>(positionSequence, CoordinateReferenceSystems.PROJECTED_2D_METER);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CustomException("坐标格式不正确！");
        }

    }
}
