package com.coinbase.exchange.api.entity.gson;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * @author msmyers
 * @since 11/24/16
 */
public class MoneyTypeAdapter implements JsonSerializer<Money>, JsonDeserializer<Money> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoneyTypeAdapter.class);

    //region getInstance()
    private static MoneyTypeAdapter instance = new MoneyTypeAdapter();

    @Nonnull
    public static MoneyTypeAdapter getInstance() {
        return instance;
    }
    //endregion

    @Override
    public JsonElement serialize(Money money, Type type, JsonSerializationContext context) {
        JsonObject object = new JsonObject();

        object.addProperty("amount", money.getAmount().toPlainString());
        object.addProperty("currency", money.getCurrencyUnit().toString());

        return object;
    }

    @Override
    @Nullable
    public Money deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (GsonUtil.isNull(element)) {
            return null;
        }

        String amountString = GsonUtil.optString(element, "amount");
        String currencyString = GsonUtil.optString(element, "currency");

        if (StringUtils.isBlank(amountString)) {
            throw new JsonParseException("Unable to parse. amountString is blank");
        }

        if (StringUtils.isBlank(currencyString)) {
            throw new JsonParseException("Unable to parse. currencyString is blank");
        }

        BigDecimal amount = NumberUtils.createBigDecimal(amountString);
        CurrencyUnit currencyUnit = CurrencyUnit.getInstance(currencyString);

        return Money.of(currencyUnit, amount);
    }
}
