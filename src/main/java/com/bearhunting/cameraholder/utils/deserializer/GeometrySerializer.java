package com.bearhunting.cameraholder.utils.deserializer;

import com.bearhunting.cameraholder.domain.Coordinate;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.geolatte.geom.C2D;
import org.geolatte.geom.Geometry;
import org.geolatte.geom.GeometryType;


/**
 * ClassName:HttpResultCode
 * Package:com.bearhunting.cameraholder.common
 * Description: 多边形反序列化
 * @date:2019/11/15 9:39
 * @author:lvlele@bearhunting.cn
 */
public class GeometrySerializer extends JsonSerializer<Geometry<C2D>> {
    @Override
    public void serialize(Geometry<C2D> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

        if (value == null) {
            gen.writeObject(null);
        } else {
            GeometryType geometryType = value.getGeometryType();
            if (geometryType == GeometryType.POLYGON || geometryType == GeometryType.LINE_STRING) {
                gen.writeStartArray();
                for (C2D p : value.getPositions()) {
                    Coordinate coordinate = new Coordinate(p.getX(), p.getY());
                    gen.writeObject(coordinate);
                }
                gen.writeEndArray();
            }
            if (geometryType == GeometryType.POINT) {
                C2D p = value.getPositions().getPositionN(0);
                Coordinate coordinate = new Coordinate(p.getX(), p.getY());
                gen.writeObject(coordinate);
            }
        }


    }
}
