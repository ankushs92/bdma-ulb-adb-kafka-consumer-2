package bdma.ulb.adb.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.ByteArrayDeserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

/**
 * Created by ankushsharma on 26/02/18.
 */
@Configuration
class KafkaConsumerConfig {


    @Value("\${kafka.bootstrap.servers}")
    private String bootstrapServers;

    @Bean
    Map<String, Object> consumerConfigs() {

        Map<String, Object> props = new HashMap<>()
        // list of host:port pairs used for establishing the initial connections
        // to the Kakfa cluster
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                ByteArrayDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "kc-clicks-mysql")
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10")
        props.put("auto.offset.reset", "earliest")

        return props
    }

    @Bean
    ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs())
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
