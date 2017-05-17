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
package co.edu.uniandes.csw.musica.resources;

import co.edu.uniandes.csw.musica.dtos.ArtistaDTO;
import co.edu.uniandes.csw.musica.dtos.ArtistaDetailDTO;
import co.edu.uniandes.csw.musica.dtos.ArtistasStringDTO;
import co.edu.uniandes.csw.musica.ejbs.ArtistaLogic;
import co.edu.uniandes.csw.musica.entities.ArtistaEntity;
import co.edu.uniandes.csw.musica.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author a.echeverrir
 */
@Path("/artistas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtistaResource {

    @Inject
    private ArtistaLogic logic;
    @Context
    HttpServlet http;

    private List<ArtistaDetailDTO> listEntity2DTO(List<ArtistaEntity> entityList) {
        List<ArtistaDetailDTO> listDTO = new ArrayList<>();
        for (ArtistaEntity c : entityList) {
            ArtistaDetailDTO est = new ArtistaDetailDTO(c);
            listDTO.add(est);
        }
        return listDTO;
    }

    @GET
    public List<ArtistaDetailDTO> getArtistas() {
        return listEntity2DTO(logic.getArtistas());

    }

    @POST
    public ArtistaDetailDTO createArtista(ArtistaDetailDTO dto) throws BusinessLogicException {
        ArtistaEntity artista = logic.createArtista(dto.toEntity());
        return new ArtistaDetailDTO(artista);
    }

    @PUT
    @Path("{id: \\d+}")
    public ArtistaDetailDTO updateArtista(@PathParam("id") Long id, ArtistaDTO dto) {
        ArtistaEntity entity = dto.toEntity();
        entity.setId(id);
        return new ArtistaDetailDTO(logic.updateArtista(entity));
    }

    @GET
    @Path("{id: \\d+}")
    public ArtistaDetailDTO getArtista(@PathParam("id") Long id) throws BusinessLogicException {
        return new ArtistaDetailDTO(logic.getArtista(id));
    }

    @GET
    @Path("festival/{id: \\d+}")
    public List<ArtistaDetailDTO> getArtistasPorFestival(@PathParam("id") Long id) throws BusinessLogicException {
        return listEntity2DTO(logic.getArtistasPorFestival(id));

    }

    @GET
    @Path("festival/String/{id: \\d+}")
    public ArtistasStringDTO getArtistasPorFestivalString(@PathParam("id") Long id) throws BusinessLogicException {
        ArrayList<ArtistaEntity> artistas = (ArrayList) logic.getArtistasPorFestival(id);
        if (artistas.size() >= 1) {
            String val = artistas.get(0).getNombre();
            for (int i = 1; i < artistas.size(); i++) {
                val += ", ";
                val += artistas.get(i).getNombre();
            }
            ArtistasStringDTO artista = new ArtistasStringDTO();
            artista.setValue(val);
            return artista;
        } else {
            ArtistasStringDTO artista = new ArtistasStringDTO();
            artista.setValue("");
            return artista;
        }

    }

    // TODO implementar get /artistas/:id/funciones funciones en las que actuará el artista
}
