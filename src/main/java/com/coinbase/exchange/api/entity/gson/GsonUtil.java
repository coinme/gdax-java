package com.coinbase.exchange.api.entity.gson;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;

/**
 * @author msmyers
 * @since 11/24/16
 */
public class GsonUtil {

//    @Nullable
//    public static Date optDate(@Nullable final JsonElement json, @Nonnull final String key, @Nullable final Date defaultValue) {
//        JsonPrimitive primitive = optPrimitive(json, key);
//
//        if (isNull(primitive)) {
//            return defaultValue;
//        }
//
//        if (primitive.isString()) {
//            final String string = primitive.getAsString();
//
//            if (!StringUtils.isNumeric(string)) {
//                throw new IllegalStateException("We do not yet support custom formats");
//            } else {
//                // Convert the string to a number.
//                return ConversionUtils.optDate(ConversionUtils.optLong(string), defaultValue);
//            }
//        } else if (primitive.isNumber()) {
//            return ConversionUtils.optDate(ConversionUtils.optLong(primitive.getAsNumber()), defaultValue);
//        }
//
//        return null;
//    }

    @Nullable
    public static Number optNumber(@Nullable final JsonElement json) {
        @Nullable
        JsonPrimitive primitive = optPrimitive(json);

        if (null == primitive) {
            return null;
        }

        if (primitive.isNumber()) {
            return primitive.getAsNumber();
        } else {
            return null;
        }
    }

    @Nullable
    public static Number optNumber(@Nullable final JsonElement json, @Nonnull final String key) {
        JsonPrimitive primitive = optPrimitive(json, key);

        if (isNull(primitive)) {
            return null;
        }

        if (!primitive.isNumber()) {
            if (primitive.isString()) {
                try {
                    return NumberUtils.createLong(primitive.getAsString());
                } catch (NumberFormatException e) {
                    return null;
                }
            }

            return null;
        }

        return primitive.getAsNumber();
    }

    @Nullable
    public static JsonPrimitive optPrimitive(@Nullable final JsonElement json) {
        if (isNull(json)) {
            return null;
        }

        if (!json.isJsonPrimitive()) {
            return null;
        }

        return (JsonPrimitive) json;
    }

    public static JsonPrimitive optPrimitive(@Nullable final JsonElement json, @Nonnull final String key) {
        return optPrimitive(opt(json, key));
    }

    @Nullable
    public static JsonObject optObject(@Nullable final JsonElement json, @Nonnull final String key) {
        return optObject(opt(json, key));
    }

    @Nullable
    public static JsonElement opt(@Nullable final JsonElement json, @Nonnull final String key) {
        @Nullable
        final JsonObject object = optObject(json);

        if (null == object) {
            return null;
        }

        return object.get(key);
    }

    @Nullable
    public static JsonObject optObject(@Nullable final JsonElement json) {
        if (isNull(json)) {
            return null;
        }

        if (!json.isJsonObject()) {
            return null;
        }

        return (JsonObject) json;
    }

    public static boolean isNull(@Nullable final JsonElement json) {
        return (null == json || json.isJsonNull());
    }

    @Nullable
    public static String optString(@Nullable final JsonElement json, @Nonnull final String key) {
        return optString(optPrimitive(json, key));
    }

    @Nullable
    public static Boolean optBoolean(@Nullable final JsonElement json, @Nonnull final String key) {
        return optBoolean(optPrimitive(json, key));
    }

    @Nullable
    public static Boolean optBoolean(@Nullable final JsonPrimitive json) {
        if (isNull(json) || !json.isBoolean()) {
            return null;
        }

        return json.getAsBoolean();
    }

    @Nullable
    public static Long optLong(@Nullable final JsonElement json, @Nonnull final String key) {
        return optLong(optPrimitive(json, key));
    }

    @Nullable
    public static Long optLong(@Nullable final JsonPrimitive json) {
        if (null == json) {
            return null;
        }

        return json.getAsLong();
    }

    @Nullable
    public static String optString(@Nullable final JsonElement json) {
        if (!isString(json)) {
            return null;
        }

        //noinspection ConstantConditions
        return json.getAsString();
    }

    public static boolean isObject(@Nullable final JsonElement json) {
        return !isNull(json) && json.isJsonObject();
    }

    public static boolean isArray(@Nullable final JsonElement json) {
        return !isNull(json) && json.isJsonArray();
    }

    public static boolean isPrimitive(@Nullable final JsonElement json) {
        if (isNull(json)) {
            return false;
        }

        return json.isJsonPrimitive();
    }

    public static boolean isString(@Nullable final JsonElement json) {
        if (!isPrimitive(json)) {
            return false;
        }

        return isString((JsonPrimitive) json);
    }

    public static boolean isString(@Nullable final JsonPrimitive json) {
        if (isNull(json)) {
            return false;
        }

        return json.isString();
    }

    public static boolean isBoolean(@Nullable final JsonPrimitive json) {
        if (isNull(json)) {
            return false;
        }

        return json.isBoolean();
    }

    @Nullable
    public static <T> T opt(@Nonnull final Gson gson, @Nullable final String string, Class<T> clazz) {
        if (StringUtils.isBlank(string)) {
            return null;
        }

        return gson.fromJson(string, clazz);
    }

    public static void addProperty(@Nonnull final JsonObject object, @Nonnull final String key, @Nullable final Boolean value) {
        if (null == value) {
            object.add(key, JsonNull.INSTANCE);
        } else {
            object.addProperty(key, value);
        }
    }

    @Nonnull
    public static <T, R extends JsonElement> JsonArray toArray(Collection<T> items, Function<T, R> adapter) {
        JsonArray array = new JsonArray();

        if (null != items) {
            for (T item : items) {
                array.add(adapter.apply(item));
            }
        }

        return array;
    }

    public static boolean isNumber(@Nullable final JsonElement json) {
        @Nullable
        final JsonPrimitive primitive = optPrimitive(json);

        if (isNull(primitive)) {
            return false;
        }

        return primitive.isNumber();
    }

    public static boolean isNumeric(@Nullable final JsonElement json) {
        @Nullable
        final JsonPrimitive primitive = optPrimitive(json);

        if (isNull(primitive)) {
            return false;
        } else if (isNumber(primitive)) {
            return true;
        } else if (isString(primitive)) {
            return StringUtils.isNumeric(primitive.getAsString());
        }

        return false;
    }
}
