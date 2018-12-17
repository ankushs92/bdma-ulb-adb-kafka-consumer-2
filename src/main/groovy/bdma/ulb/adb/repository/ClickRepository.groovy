package bdma.ulb.adb.repository

import bdma.ulb.adb.domain.Click
import org.springframework.data.jpa.repository.JpaRepository

interface ClickRepository extends JpaRepository<Click, Integer> {
}
