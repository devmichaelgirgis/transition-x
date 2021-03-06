/*
 * Copyright 2018 Arunkumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package `in`.arunkumarsampath.transitionx.sample.home.transitionsamples


import `in`.arunkumarsampath.transitionx.prepareTransition
import `in`.arunkumarsampath.transitionx.sample.R
import android.os.Bundle
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.view.View
import kotlinx.android.synthetic.main.layout_scale_rotate_content.*


class ScaleRotateFragment : BaseSampleFragment() {

    override val contentLayoutResource = R.layout.layout_scale_rotate_content
    override val titleRes = R.string.scale_rotate_transition

    private var toggle = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            constraintLayout.prepareTransition {
                scaleRotate {
                    +arrowIconView
                    interpolator = FastOutLinearInInterpolator()
                }
            }

            with(arrowIconView) {
                if (toggle) {
                    scaleY = 2F
                    scaleX = 2F
                } else {
                    scaleY = 1F
                    scaleX = 1F
                }
                rotation += 90F
                toggle = !toggle
            }
        }
    }
}
