/* 
 * The MIT License
 *
 * Copyright 2017 Mighty Fingers.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.csw.musica.ejbs;

/**
 *
 * @author af.olivares10
 */
import co.edu.uniandes.csw.musica.entities.FestivalEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.musica.persistence.FestivalPersistence;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FestivalLogic {

    @Inject
    FestivalPersistence persistence;

    public List<FestivalEntity> getFestivales() {
        return persistence.findAll();
    }

    public FestivalEntity getSiguiente(Long id) {
        List<FestivalEntity> lista = persistence.findAll();
        Iterator<FestivalEntity> it = lista.iterator();
        if (it.hasNext()) {
            FestivalEntity first = it.next();
            if (Objects.equals(first.getId(), id)) {
                if (it.hasNext()) {
                    return it.next();
                }
                return first;
            }

            while (it.hasNext()) {
                if (Objects.equals(it.next().getId(), id)) {
                    if (it.hasNext()) {
                        return it.next();
                    } else {
                        return first;

                    }
                }
            }
        }
        return null;

    }

    public FestivalEntity getAnterior(Long id) {
        List<FestivalEntity> lista = persistence.findAll();
        Iterator<FestivalEntity> it = lista.iterator();
        FestivalEntity anterior = it.next();
        FestivalEntity actual;
        while (it.hasNext()) {
            actual = it.next();
            if (Objects.equals(anterior.getId(), id)) {
                return getLast(it);
            }
            if (Objects.equals(actual.getId(), id)) {
                return anterior;
            }
            anterior = actual;
        }
        return null;
    }

    public FestivalEntity getLast(Iterator<FestivalEntity> it) {
        FestivalEntity fest;
        while (it.hasNext()) {
            fest = it.next();
            if (!it.hasNext()) {
                return fest;
            }
        }
        return it.next();
    }

    public FestivalEntity getFestival(Long id) {
        return persistence.find(id);
    }

    public List getFestivalesPorGenero(Long genero) {
        return persistence.findPorGenero(genero);
    }

    public FestivalEntity createFestival(FestivalEntity festival) {
        return persistence.create(festival);
    }

    public FestivalEntity updateFestival(FestivalEntity festival) {
        return persistence.update(festival);
    }

    public FestivalEntity deleteFestival(Long id) {
        return persistence.delete(id);
    }

}
