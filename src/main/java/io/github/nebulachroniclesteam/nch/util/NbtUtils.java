package io.github.nebulachroniclesteam.nch.util;

import io.github.nebulachroniclesteam.nch.NebulaChronicles;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.UUID;

public class NbtUtils {

    public static <T extends Enum<T>> T getEnum(CompoundTag tag, String name, T defaultValue) {
        Class<T> aClass = (Class<T>) defaultValue.getClass();
        return tag.contains(name, Tag.TAG_INT) ? aClass.getEnumConstants()[tag.getInt(name)] : defaultValue;
    }

    public static void setEnum(CompoundTag tag, String name, Enum<?> value) {
        tag.putInt(name, value.ordinal());
    }

    public static void writeAllFields(Object container, CompoundTag tag) {
        for (Field field : container.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            Class<?> type = field.getType();
            try {
                if (type == Integer.TYPE) {
                    tag.putInt(buildName(field.getName()), field.getInt(container));
                } else if (type == Byte.TYPE) {
                    tag.putByte(buildName(field.getName()), field.getByte(container));
                } else if (type == Boolean.TYPE) {
                    tag.putBoolean(buildName(field.getName()), field.getBoolean(container));
                } else if (type == Float.TYPE) {
                    tag.putFloat(buildName(field.getName()), field.getFloat(container));
                } else if (type == String.class) {
                    tag.putString(buildName(field.getName()), (String) field.get(container));
                } else if (type == UUID.class) {
                    tag.putUUID(buildName(field.getName()), (UUID) field.get(container));
                } else if (type.isEnum()) {
                    setEnum(tag, buildName(field.getName()), (Enum<?>) field.get(container));
                } else {
                    throw new IllegalArgumentException("Unsupported type " + type + " in field " + container.getClass().getSimpleName() + "." + field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Unexpected access exception in " + container.getClass().getSimpleName() + "." + field.getName() + " [" + type + "]", e);
            }
        }
    }

    public static void readAllFields(Object container, CompoundTag tag) {
        for (Field field : container.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            Class<?> type = field.getType();
            try {
                if (type == Integer.TYPE) {
                    field.setInt(container, tag.getInt(buildName(field.getName())));
                } else if (type == Byte.TYPE) {
                    field.setByte(container, tag.getByte(buildName(field.getName())));
                } else if (type == Boolean.TYPE) {
                    field.setBoolean(container, tag.getBoolean(buildName(field.getName())));
                } else if (type == Float.TYPE) {
                    field.setFloat(container, tag.getFloat(buildName(field.getName())));
                } else if (type == String.class) {
                    field.set(container, tag.getString(buildName(field.getName())));
                } else if (type == UUID.class) {
                    field.set(container, tag.getUUID(buildName(field.getName())));
                } else if (type.isEnum()) {
                    field.set(container, getEnum(tag, buildName(field.getName()), (Enum) field.get(container)));
                } else {
                    throw new IllegalArgumentException("Unsupported type " + type + " in field " + container.getClass().getSimpleName() + "." + field.getName());
                }
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Unexpected access exception in " + container.getClass().getSimpleName() + "." + field.getName() + " [" + type + "]", e);
            }
        }
    }

    private static String buildName(String name) {
        return NebulaChronicles.MOD_ID + "." + name;
    }
}
